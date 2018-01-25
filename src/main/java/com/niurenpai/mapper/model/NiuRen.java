package com.niurenpai.mapper.model;

import lombok.Data;

import java.util.Date;
@Data
public class NiuRen {
    private Long id;

    private String headImgUrl;

    private String name;

    private String nickName;

    private String idCard;

    private Integer sex;

    private Date birthday;

    private Integer workLife;

    private Integer education;

    private String school;

    private String introduction;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}