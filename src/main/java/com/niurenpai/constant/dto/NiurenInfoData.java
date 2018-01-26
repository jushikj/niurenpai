package com.niurenpai.constant.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 牛人个人信息
 */
@Data
@ToString
public class NiurenInfoData implements Serializable{

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 工作年限
     */
    private String workLife;
}
