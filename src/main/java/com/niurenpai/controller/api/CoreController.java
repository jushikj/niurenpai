package com.niurenpai.controller.api;

import com.niurenpai.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public String index(int city, int job, int pageNo, int pageSize) {

        //分页查询竞拍计划列表
        //名字，职位名称，拍卖倒计时，背景图
        //id,nickName,job,status(0:即将开始1：竞猜中2：竞拍中3：结束)，auctionEndTime(竞拍结束时间)

        return null;
    }

    /**
     * 牛人详情
     * @return
     */
    @RequestMapping("/niurenpai/niuren/detail")
    @ResponseBody
    public String niurenDetail() {

        //头像，牛人介绍图片，问答，竞猜时间和状态，我的状态
        //headImageUrl,introductionImgUrl,[{quesion,answer}],guessStartTime,guessEndTime,auctionEndTime,guessSatus
        return null;
    }

    /**
     * 竞猜
     * @return
     */
    @RequestMapping("/niurenpai/guess")
    @ResponseBody
    public String guess() {


        return null;
    }

    /**
     * 竞猜记录
     * @return
     */
    @RequestMapping("/niurenpai/guess/record")
    @ResponseBody
    public String guessRecord() {
        //头像，花名，竞拍人数，竞猜出价，成交价格，竞猜结果
        //headImageUrl,nickName,guessNum,auctionPrice,dealPrice,guessStatus
        return null;
    }

    /**
     * 交易流水
     * @return
     */
    @RequestMapping("/niurenpai/user/tradeRecord")
    @ResponseBody
    public String tradeRecord(){
        //流水名称，时间，金额
        //title,tradeTime,amount
        return null;
    }


}
