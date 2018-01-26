package com.niurenpai.constant.dto;

import com.niurenpai.mapper.model.User;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NiurenDetailQuery implements Serializable{

    /**
     * 计划id
     */
    private String auctoinPlanId;

    /**
     * 牛人id
     */
    private String niurenId;

    /**
     * 用户信息
     */
    private User user;

}
