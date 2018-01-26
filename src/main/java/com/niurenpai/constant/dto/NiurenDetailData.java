package com.niurenpai.constant.dto;

import com.niurenpai.mapper.model.NiuRenAuth;
import com.niurenpai.mapper.model.NiuRenIntension;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 牛人详情
 */
@Data
@ToString
public class NiurenDetailData implements Serializable {

    /**
     * 计划编号
     */
    private String auctionPlanNum;

    /**
     * 牛人头像
     */
    private String niurenHeadImgUrl;

    /**
     * 牛人简介-顶部
     */
    private String niurenDescShort;

    /**
     * 牛人求职意向-顶部
     */
    private String niurenIntentionShort;

    /**
     * 牛人详细介绍
     */
    private String niurenDescDetail;

    /**
     * 个人信息
     */
    private NiurenInfoData niurenInfoData;

    /**
     * 工作经验
     */
    private List<String> niurenWorkExp;

    /**
     * 求职意向
     */
    private NiuRenIntension niuRenIntension;

    /**
     * 平台认证
     */
    private NiuRenAuth niuRenAuth;

}
