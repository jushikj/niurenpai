package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.GuessRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GuessRecordMapper {

    @Insert({
        "insert into nrp_guess_record (id, auction_plan_id, ",
        "niuren_id, open_id, ",
        "amount, ",
        " status",
        ")",
        "values (#{id,jdbcType=BIGINT}, #{auctionPlanId,jdbcType=BIGINT}, ",
        "#{niurenId,jdbcType=BIGINT}, #{openId,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DECIMAL}, ",
        " #{status,jdbcType=INTEGER} ",
        ")"
    })
    int insert(GuessRecord record);

    @Select({
            "select * ",
            "from nrp_guess_record",
            "where open_id=#{openId} and yn=0 order by id desc"
    })
    @ResultMap("com.niurenpai.mapper.dao.GuessRecordMapper.BaseResultMap")
    List<GuessRecord> selectByOpenId(@Param("openId") String openId);

    @Select({
            "select count(id) ",
            "from nrp_guess_record",
            "where auction_plan_id=#{auctionPlanId} and yn=0 "
    })
    int countByPlanId(@Param("auctionPlanId") long auctionPlanId);
}
