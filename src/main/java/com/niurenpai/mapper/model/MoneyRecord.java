package com.niurenpai.mapper.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 流水
 */
@Data
public class MoneyRecord {
    private Long id;
    /**
     * 用户id
     */
    private String openId;

    private Integer busiType;

    private String busiDesc;

    private BigDecimal amount;

    private BigDecimal totalAmount;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}
