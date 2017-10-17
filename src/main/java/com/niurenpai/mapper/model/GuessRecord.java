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
     * 竞猜金额
     */
    private BigDecimal amount;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer yn;

}
