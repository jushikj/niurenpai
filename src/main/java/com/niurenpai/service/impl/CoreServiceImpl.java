package com.niurenpai.service.impl;

import com.niurenpai.constant.dto.*;
import com.niurenpai.mapper.dao.*;
import com.niurenpai.mapper.model.*;
import com.niurenpai.service.CoreService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author meng.haoran
 * @create 2017/9/13 20:51
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AuctionPlanMapper auctionPlanMapper;
    @Autowired
    AuctionRecordMapper auctionRecordMapper;
    @Autowired
    GuessRecordMapper guessRecordMapper;
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    MoneyRecordMapper moneyRecordMapper;
    @Autowired
    NiuRenMapper niuRenMapper;
    @Autowired
    UserAccountMapper userAccountMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NiuRenWorkexpMapper niuRenWorkexpMapper;
    @Autowired
    NiuRenIntensionMapper niuRenIntensionMapper;
    @Autowired
    NiuRenAuthMapper niuRenAuthMapper;

    @Override
    public List<AuctionPlanData> queryAuctionPlanData(AuctionPlanQuery auctionPlanQuery) {

        List<AuctionPlanData> auctionPlanDataList = new ArrayList<>();
        //查询拍卖计划列表
        List<AuctionPlan> auctionPlanList = auctionPlanMapper.selectAll();
        if (CollectionUtils.isEmpty(auctionPlanList)) {
            return auctionPlanDataList;
        }

        for (AuctionPlan auctionPlan : auctionPlanList) {
            AuctionPlanData auctionPlanData = new AuctionPlanData();
            //计划id
            auctionPlanData.setAuctionPlanId(auctionPlan.getPlanId());
            //牛人id
            auctionPlanData.setNiurenId(auctionPlan.getNiurenId());
            //拍卖编号
            auctionPlanData.setPlanNum("NO."+auctionPlan.getPlanNum()+"号");
            //背景图
            auctionPlanData.setBackImgUrl(auctionPlan.getBackImgUrl());
            //计划描述 日期|城市|职业
            //创建日期
            Date createTime = auctionPlan.getCreateTime();
            DateTime dateTime = new DateTime(createTime);
            String createTimeStr = dateTime.toString("MM月dd日");
            auctionPlanData.setPlanDesc(createTimeStr+"|"+auctionPlan.getCityDesc()+"|"+auctionPlan.getJobDesc());
            //计划状态
            Date guessStartTime = auctionPlan.getGuessStartTime();
            Date guessEndTime = auctionPlan.getGuessEndTime();
            Date auctionEndTime = auctionPlan.getAuctionEndTime();
            Date now = new Date();
            if (now.before(guessStartTime)) {
                //即将开始
                auctionPlanData.setStatus(0);
                //开始时间
                auctionPlanData.setGuessStartTime(guessStartTime);
            }else if (now.after(guessStartTime) && now.before(guessEndTime)) {
                //竞猜中
                auctionPlanData.setStatus(1);
                //竞猜人数
                auctionPlanData.setGuessCount(auctionPlan.getGuessCount());
            }else if (now.after(guessEndTime) && now.before(auctionEndTime)) {
                //竞拍中
                auctionPlanData.setStatus(2);
            } else {
                //已结束
                auctionPlanData.setStatus(3);
            }
            User user = auctionPlanQuery.getUser();
            //用户竞猜状态
            GuessRecord userGuessRecord = guessRecordMapper.selectByOpenIdAndPlanId(user.getOpenId(),auctionPlan.getPlanId());
            if (userGuessRecord != null) {
                auctionPlanData.setUserGuessStatus(1);
                //竞猜金额
                auctionPlanData.setUserGuessAmount(userGuessRecord.getAmount());
            }else {
                auctionPlanData.setUserGuessStatus(0);
            }

            auctionPlanDataList.add(auctionPlanData);
        }
        return auctionPlanDataList;
    }

    @Override
    public NiurenDetailData queryNiurenDetail(NiurenDetailQuery query) throws Exception{

        NiurenDetailData niurenDetailData = new NiurenDetailData();

        //查询计划
        AuctionPlan auctionPlan = auctionPlanMapper.selectByPlanId(query.getAuctoinPlanId());
        if (auctionPlan == null) {
            logger.error("根据计划id查询拍卖计划失败,auctionPlanId={}",query.getAuctoinPlanId());
            throw new Exception("查询拍卖计划失败");
        }
        //查询牛人
        NiuRen niuRen = niuRenMapper.selectByNiurenId(query.getNiurenId());
        if (niuRen == null) {
            logger.error("根据牛人id查询牛人信息失败,niurenId={}",query.getNiurenId());
            throw new Exception("查询牛人信息失败");
        }

        //计划编号
        niurenDetailData.setAuctionPlanNum("NO."+auctionPlan.getPlanNum()+"号");

        //头像
        niurenDetailData.setNiurenHeadImgUrl(auctionPlan.getBackImgUrl());

        //简介-短
        //性别 年龄 学历 工作年限 城市
        String sex = niuRen.getSex()==0?"女":"男";
        niurenDetailData.setNiurenDescShort(sex +" " +niuRen.getAge()+"岁"+" " +niuRen.getEducation()+" " + niuRen.getWorkLife()+"年工作经验 ");

        //求职意向
        niurenDetailData.setNiurenIntentionShort(niuRen.getIntroduction());

        //简介
        niurenDetailData.setNiurenDescDetail(niuRen.getIntroduction());

        //个人信息
        NiurenInfoData niurenInfoData = new NiurenInfoData();
        niurenInfoData.setSex(niuRen.getSex()==0?"女":"男");
        niurenInfoData.setBirthday(niuRen.getBirthday().toString());
        niurenInfoData.setWorkLife(niuRen.getWorkLife()+"年");

        niurenDetailData.setNiurenInfoData(niurenInfoData);

        //工作经验
        List<String> niurenWorkExp = new ArrayList<>();
        List<NiuRenWorkexp> workexps = niuRenWorkexpMapper.selectByNiurenId(query.getNiurenId());
        if (!CollectionUtils.isEmpty(workexps)) {
            for (NiuRenWorkexp workexp : workexps) {
                niurenWorkExp.add(workexp.getCompany()+" " + workexp.getJob() + " " + workexp.getWorkLife()+"年");
            }
        }

        niurenDetailData.setNiurenWorkExp(niurenWorkExp);

        NiuRenIntension niuRenIntension = niuRenIntensionMapper.selectByNiurenId(query.getNiurenId());
        //求职意向
        niurenDetailData.setNiuRenIntension(niuRenIntension);

        //平台认证
        NiuRenAuth niuRenAuth = niuRenAuthMapper.selectByNiurenId(query.getNiurenId());
        niurenDetailData.setNiuRenAuth(niuRenAuth);

        //用户计划状态
        UserPlanStatus userPlanStatus = new UserPlanStatus();

        //计划状态
        Date guessStartTime = auctionPlan.getGuessStartTime();
        Date guessEndTime = auctionPlan.getGuessEndTime();
        Date auctionEndTime = auctionPlan.getAuctionEndTime();
        Date now = new Date();
        if (now.before(guessStartTime)) {
            //即将开始
            userPlanStatus.setPlanStatus(0);
            //开始时间
            userPlanStatus.setGuessStartTime(guessStartTime);
        }else if (now.after(guessStartTime) && now.before(guessEndTime)) {
            //竞猜中
            userPlanStatus.setPlanStatus(1);
            //竞猜人数
            auctionPlan.setGuessCount(auctionPlan.getGuessCount());
        }else if (now.after(guessEndTime) && now.before(auctionEndTime)) {
            //竞拍中
            userPlanStatus.setPlanStatus(2);
        } else {
            //已结束
            userPlanStatus.setPlanStatus(3);
        }
        User user = query.getUser();
        //用户竞猜状态
        GuessRecord userGuessRecord = guessRecordMapper.selectByOpenIdAndPlanId(user.getOpenId(),auctionPlan.getPlanId());
        if (userGuessRecord != null) {
            userPlanStatus.setUserGuessStatus(1);
            //竞猜金额
            userPlanStatus.setUserGuessAmount(userGuessRecord.getAmount());
        }else {
            userPlanStatus.setUserGuessStatus(0);
        }

        //TODO 如果用户有竞拍权限，查询竞拍状态
        niurenDetailData.setUserPlanStatus(userPlanStatus);

        //TODO 曲线图

        return niurenDetailData;
    }

    @Override
    public boolean guess(String auctionPlanId, String openId, BigDecimal amount) {

        AuctionPlan auctionPlan = auctionPlanMapper.selectByPrimaryKey(auctionPlanId);

        //保存用户的竞猜记录
        GuessRecord guessRecord = new GuessRecord();
        guessRecord.setAuctionPlanId(auctionPlanId);
        guessRecord.setOpenId(openId);
        guessRecord.setAmount(amount);
       // guessRecord.setAuctionPlanId(auctionPlanId);
        guessRecord.setStatus(0);
        guessRecord.setNiurenId(auctionPlan.getNiurenId());
        int i = guessRecordMapper.insert(guessRecord);

        //更新计划中的更新次数

        i = auctionPlanMapper.increGuessCount(auctionPlanId);

        return i>0;
    }

    @Override
    public List<Map<String, Object>> guessRecord(String openId) {

        List<Map<String,Object>> result = new ArrayList<>();

        //根据openid 查询竞猜记录
        List<GuessRecord> guessRecordList = guessRecordMapper.selectByOpenId(openId);

        if (!CollectionUtils.isEmpty(guessRecordList)) {
            for (GuessRecord guessRecord : guessRecordList) {
                Map<String,Object> guessMap = new HashMap<>();
                //牛人
               // NiuRen niuRen = niuRenMapper.selectByPrimaryKey(guessRecord.getNiurenId());
                //计划
                //AuctionPlan auctionPlan = auctionPlanMapper.selectByPrimaryKey(guessRecord.getAuctionPlanId());
                //昵称
                //guessMap.put("nickName",niuRen.getNickName());
                //竞猜金额
                guessMap.put("auctionPrice",guessRecord.getAmount());
                //竞猜状态
                guessMap.put("guessStatus",guessRecord.getStatus());
                //成交金额
                //guessMap.put("dealPrice",auctionPlan.getDealAmount());
                //总竞猜人数
                //int countGuessNum = guessRecordMapper.countByPlanId(guessRecord.getAuctionPlanId());
                //guessMap.put("guessNum",countGuessNum);

                result.add(guessMap);
            }
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> moneyRecord(String openId) {

        List<Map<String,Object>> resultList = new ArrayList<>();

        List<MoneyRecord> moneyRecordList = moneyRecordMapper.selectByOpenId(openId);

        if (!CollectionUtils.isEmpty(moneyRecordList)) {
            for (MoneyRecord moneyRecord : moneyRecordList) {
                Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("title",moneyRecord.getBusiDesc());
                resultMap.put("amount",moneyRecord.getAmount());
                resultMap.put("tradeTime",moneyRecord.getCreateTime());
                resultList.add(resultMap);
            }
        }

        return resultList;
    }
}
