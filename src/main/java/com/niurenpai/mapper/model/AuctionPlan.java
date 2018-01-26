package com.niurenpai.mapper.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 拍卖计划
 */
@Data
public class AuctionPlan {

    private Long id;

    private String planId;

    /**
     * 牛人id
     */
    private String niurenId;

    /**
     * 编号
     */
    private String planNum;

    /**
     * 背景图
     */
    private String backImgUrl;
    /**
     * 竞猜开始时间
     */
    private Date guessStartTime;
    /**
     * 竞猜结束时间
     */
    private Date guessEndTime;
    /**
     * 竞拍结束时间
     */
    private Date auctionEndTime;

    private Date createTime;

    private Date updateTime;
    /**
     * 城市
     */
    private Integer city;

    private String cityDesc;

    /**
     * 职位大类
     */
    private Integer job;

    private String jobDesc;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 竞猜总人数
     */
    private long guessCount;

    /**
     * 成交金额
     */
    private BigDecimal dealAmount;

    /**
     * 是否热门
     */
    private int isHot;

    private Integer yn;

}
