package com.niurenpai.mapper.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 竞猜记录
 */
@Data
public class GuessRecord {
    private Long id;
    /**
     * 拍卖计划id
     */
    private String auctionPlanId;
    /**
     * 牛人id
     */
    private String niurenId;
    /**
     * 用户id
     */
    private String openId;
    /**
     * 竞猜金额
     */
    private BigDecimal amount;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer yn;

}
