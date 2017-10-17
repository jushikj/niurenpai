package com.niurenpai.constant.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author meng.haoran
 * @create 2017/10/17 21:57
 */
@Data
public class AuctionPlanQuery implements Serializable{

    private int city;

    private int job;

    private int pageNo;

    private int pageSize;

}
