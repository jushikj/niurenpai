package com.niurenpai.service;

import com.niurenpai.constant.dto.AuctionPlanData;
import com.niurenpai.constant.dto.AuctionPlanQuery;

import java.util.List;

/**
 * @author meng.haoran
 * @create 2017/9/13 20:51
 */
public interface CoreService {

    /**
     * 首页拍卖计划列表
     * @return
     */
    List<AuctionPlanData> queryAuctionPlanData(AuctionPlanQuery auctionPlanQuery);



}
