package com.niurenpai.mapper.model;

import lombok.Data;

import java.util.Date;

/**
 * 拍卖计划
 */
@Data
public class AuctionPlan {

    private Long id;
    /**
     * 牛人id
     */
    private Long niurenId;
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
    /**
     * 职位大类
     */
    private Integer job;
    /**
     * 状态
     */
    private Integer status;

    private Integer yn;

}
