package com.niurenpai.mapper.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class NiuRenIntension {
    private Long id;

    private Long niurenId;

    private String expectJob;

    private String currentCity;

    private String targetCity;

    private String currentSalary;

    private String expectSalary;

    private String entryTime;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}