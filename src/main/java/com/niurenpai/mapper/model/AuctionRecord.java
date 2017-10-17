package com.niurenpai.mapper.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 竞拍记录
 */
@Data
public class AuctionRecord {
    private Long id;
    /**
     * 竞拍计划id
     */
    private Long auctionPlanId;
    /**
     * 牛人id
     */
    private Long niurenId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 竞拍金额
     */
    private BigDecimal amount;
    /**
     * 公司名称
     */
    private String company;

    private Date createTime;

    private Date updateTime;
    /**
     * 状态
     */
    private Integer status;

    private Integer yn;

}
