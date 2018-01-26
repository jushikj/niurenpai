package com.niurenpai.mapper.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class NiuRen {
    private Long id;

    /**
     * 牛人id
     */
    private String niurenId;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年纪
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 工作年限
     */
    private Integer workLife;

    /**
     * 学历
     */
    private String education;

    /**
     * 最高学历学校
     */
    private String school;

    /**
     *简介
     */
    private String introduction;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}