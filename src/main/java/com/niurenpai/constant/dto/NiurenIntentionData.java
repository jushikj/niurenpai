package com.niurenpai.constant.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 牛人求职意向
 */
@Data
@ToString
public class NiurenIntentionData implements Serializable {

    /**
     * 期望职位
     */
    private String expectJob;

    /**
     * 当前城市
     */
    private String currentCity;

    /**
     * 目标城市
     */
    private String targetCity;

    /**
     * 当前薪资
     */
    private String currentSalary;

    /**
     * 期望薪资
     */
    private String expectSlary;

    /**
     * 到岗时间
     */
    private String entryTime;
}
