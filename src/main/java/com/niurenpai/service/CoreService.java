package com.niurenpai.service;

import com.niurenpai.constant.dto.AuctionPlanData;
import com.niurenpai.constant.dto.AuctionPlanQuery;
import com.niurenpai.constant.dto.NiurenDetailData;
import com.niurenpai.constant.dto.NiurenDetailQuery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    /**
     * 牛人详情
     * @param niurenDetailQuery
     * @return
     */
    NiurenDetailData queryNiurenDetail(NiurenDetailQuery niurenDetailQuery) throws Exception;

    /**
     * 竞猜
     * @param auctionPlanId
     * @param openId
     * @param amount
     * @return
     */
    boolean guess(long auctionPlanId,String openId,BigDecimal amount);

    /**
     * 竞猜记录
     * @param openId
     * @return
     */
    List<Map<String,Object>> guessRecord(String openId);

    /**
     * 交易流水
     * @param openId
     * @return
     */
    List<Map<String,Object>> moneyRecord(String openId);
}
