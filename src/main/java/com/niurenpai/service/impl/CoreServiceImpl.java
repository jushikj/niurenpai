package com.niurenpai.service.impl;

import com.niurenpai.constant.dto.AuctionPlanData;
import com.niurenpai.constant.dto.AuctionPlanQuery;
import com.niurenpai.constant.dto.NiurenDetailData;
import com.niurenpai.constant.dto.NiurenDetailQuery;
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
            auctionPlanData.setPlanNum(auctionPlan.getPlanNum());
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
                auctionPlan.setGuessCount(auctionPlan.getGuessCount());
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
        niurenDetailData.setAuctionPlanNum(auctionPlan.getPlanNum());

        //头像
        niurenDetailData.setNiurenHeadImgUrl(auctionPlan.getBackImgUrl());

        //简介-短
        //性别 年龄 学历 工作年限 城市
        niurenDetailData.setNiurenDescShort(niuRen.getSex()==0?"女":"男"+" " +niuRen.getAge()+"岁"+" " +niuRen.getIntroduction()+" " + niuRen.getWorkLife()+"年工作经验 ");


        //简历图片
        /*if (niuRen != null) {
            result.put("introductionImgUrl",niuRen.getIntroductionImgUrl());
        }
        //问答
        List<Interview> interviewList = interviewMapper.selectByNiuren(niurenId);

        List<Map<String,String>> questions = new ArrayList<>();
        if (!CollectionUtils.isEmpty(interviewList)) {
            for (Interview interview : interviewList) {
                Map<String,String> interviewMap = new HashMap<>();
                interviewMap.put("question",interview.getQuestion());
                interviewMap.put("answer",interview.getAnswer());
                questions.add(interviewMap);
            }
        }
        result.put("questions",questions);

        //竞猜时间
        AuctionPlan auctionPlan = auctionPlanMapper.selectByPrimaryKey(auctionPlanId);

        if (auctionPlan != null) {
            //计划状态
            Date guessStartTime = auctionPlan.getGuessStartTime();
            Date guessEndTime = auctionPlan.getGuessEndTime();
            Date auctionEndTime = auctionPlan.getAuctionEndTime();
            Date now = new Date();
            if (now.before(guessStartTime)) {
                //即将开始
                result.put("planStatus",0);
            }else if (now.after(guessStartTime) && now.before(guessEndTime)) {
                //竞猜中
                result.put("planStatus",1);
            }else if (now.after(guessEndTime) && now.before(auctionEndTime)) {
                //竞拍中
                result.put("planStatus",2);
            } else {
                //已结束
                result.put("planStatus",3);
            }

            result.put("guessStartTime",guessStartTime);
            result.put("guessEndTime",guessEndTime);
            result.put("auctionEndTime",auctionEndTime);
        }

        //我的竞猜状态 TODO
        result.put("guessSatus",0);*/

        return niurenDetailData;
    }

    @Override
    public boolean guess(long auctionPlanId, String openId, BigDecimal amount) {

        AuctionPlan auctionPlan = auctionPlanMapper.selectByPrimaryKey(auctionPlanId);

        //保存用户的竞猜记录
        GuessRecord guessRecord = new GuessRecord();
        guessRecord.setOpenId(openId);
        guessRecord.setAmount(amount);
       // guessRecord.setAuctionPlanId(auctionPlanId);
        guessRecord.setStatus(0);
        guessRecord.setNiurenId(auctionPlan.getNiurenId());
        int i = guessRecordMapper.insert(guessRecord);
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
