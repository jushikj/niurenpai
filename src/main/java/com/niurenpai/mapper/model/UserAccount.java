package com.niurenpai.mapper.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户
 */
@Data
public class UserAccount {
    private Long id;

    private String userId;

    private BigDecimal totalAmount;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}
