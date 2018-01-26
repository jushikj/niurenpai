package com.niurenpai.constant.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author meng.haoran
 * @create 2017/10/17 21:46
 */
@Data
@ToString
public class AuctionPlanData implements Serializable{

    /**
     * 计划id
     */
    private String auctionPlanId;

    /**
     * 牛人id
     */
    private String niurenId;

    /**
     * 职位背景图
     */
    private String backImgUrl;

    /**
     * 计划编号
     */
    private String planNum;

    /**
     * 计划描述
     */
    private String planDesc;

    /**
     * 状态
     */
    private int status;

    /**
     * 竞猜结束日期
     */
    private Date auctionEndTime;

    /**
     * 竞猜开始时间
     */
    private Date guessStartTime;

    /**
     * 参与竞猜人数
     */
    private long guessCount;

    /**
     * 用户竞猜状态
     */
    private int userGuessStatus;

    /**
     * 用户竞猜出价
     */
    private BigDecimal userGuessAmount;

}
