package com.niurenpai.mapper.model;

import lombok.Data;

import java.util.Date;

/**
 * 牛人
 */
@Data
public class NiuRen {

    private Long id;

    /**
     * 介绍图片
     */
    private String introductionImgUrl;

    /**
     * 真是姓名
     */
    private String name;

    /**
     * 花名
     */
    private String nickName;

    /**
     * 职位名称
     */
    private String job;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}
