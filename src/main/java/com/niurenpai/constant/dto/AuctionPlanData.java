package com.niurenpai.constant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author meng.haoran
 * @create 2017/10/17 21:46
 */
@Data
public class AuctionPlanData implements Serializable{

    private long auctionPlanId;

    private long niurenId;

    private String backImgUrl;

    private Date auctionEndTime;

    private String niurenName;

    private String niurenNickName;

    private String job;

}
