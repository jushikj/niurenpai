package com.niurenpai.mapper.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class NiuRenWorkexp {
    private Long id;

    private Long niurenId;

    private String company;

    private String job;

    private Date startDate;

    private Date endDate;

    private Integer workLife;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}