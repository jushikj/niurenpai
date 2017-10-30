package com.niurenpai.controller.api;

import com.alibaba.fastjson.JSONArray;
import com.niurenpai.constant.dto.AuctionPlanData;
import com.niurenpai.constant.dto.AuctionPlanQuery;
import com.niurenpai.constant.dto.ResultData;
import com.niurenpai.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author meng.haoran
 * @create 2017/9/13 20:59
 */
@RestController
@EnableAutoConfiguration
public class CoreController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    CoreService coreService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/niurenpai/index")
    @ResponseBody
    public String index() {

        ResultData resultData = ResultData.newInstance();
        //分页查询竞拍计划列表
        //名字，职位名称，拍卖倒计时，背景图
        //id,nickName,job,status(0:即将开始1：竞猜中2：竞拍中3：结束)，auctionEndTime(竞拍结束时间)
        AuctionPlanQuery auctionPlanQuery = new AuctionPlanQuery();
        List<AuctionPlanData> dataList = coreService.queryAuctionPlanData(auctionPlanQuery);

        resultData.addData("auctionPlanList",dataList);

        return JSONArray.toJSONString(resultData);
    }

    /**
     * 牛人详情
     * @return
     */
    @RequestMapping("/niurenpai/niuren/detail")
    @ResponseBody
    public String niurenDetail(long auctionPlanId, long niurenId) {

        ResultData resultData = ResultData.newInstance();
        //头像，牛人介绍图片，问答，竞猜时间和状态，我的状态
        //headImageUrl,introductionImgUrl,[{quesion,answer}],guessStartTime,guessEndTime,auctionEndTime,guessSatus
        Map<String,Object> result = coreService.queryNiurenDetail(auctionPlanId,niurenId);

        resultData.addData("niurenDetail",result);

        return JSONArray.toJSONString(resultData);
    }

    /**
     * 竞猜
     * @return
     */
    @RequestMapping("/niurenpai/guess")
    @ResponseBody
    public String guess(long auctionPlanId,String openId,String amount) {
        ResultData resultData = ResultData.newInstance();
        boolean result = coreService.guess(auctionPlanId,openId,new BigDecimal(amount));
        if (!result) {
            resultData.setStatus(-1);
            resultData.setMessage("竞猜失败，请稍后重试~");
        }
        return JSONArray.toJSONString(resultData);
    }

    /**
     * 竞猜记录
     * @return
     */
    @RequestMapping("/niurenpai/guess/record")
    @ResponseBody
    public String guessRecord(String openId) {
        //头像，花名，竞拍人数，竞猜出价，成交价格，竞猜结果
        //headImageUrl,nickName,auctionNum,auctionPrice,dealPrice,guessStatus
        ResultData resultData = ResultData.newInstance();
        List<Map<String,Object>> guessRecords = coreService.guessRecord(openId);
        resultData.addData("guessRecordList",guessRecords);
        return JSONArray.toJSONString(resultData);
    }

    /**
     * 交易流水
     * @return
     */
    @RequestMapping("/niurenpai/user/tradeRecord")
    @ResponseBody
    public String tradeRecord(String openId){
        ResultData resultData = ResultData.newInstance();
        //流水名称，时间，金额
        //title,tradeTime,amount
        List<Map<String,Object>> resultList = coreService.moneyRecord(openId);
        resultData.addData("tradeRecordList",resultList);
        return JSONArray.toJSONString(resultData);
    }


}
