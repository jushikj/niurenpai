package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.AuctionRecord;
import org.apache.ibatis.annotations.*;

public interface AuctionRecordMapper {

    @Delete({
        "delete from nrp_auction_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_auction_record (id, auction_plan_id, ",
        "niuren_id, user_id, ",
        "amount, company, ",
        "create_time, update_time, ",
        "status, yn)",
        "values (#{id,jdbcType=BIGINT}, #{auctionPlanId,jdbcType=BIGINT}, ",
        "#{niurenId,jdbcType=BIGINT}, #{userId,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DECIMAL}, #{company,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{yn,jdbcType=INTEGER})"
    })
    int insert(AuctionRecord record);

    int insertSelective(AuctionRecord record);

    @Select({
        "select",
        "id, auction_plan_id, niuren_id, user_id, amount, company, create_time, update_time, ",
        "status, yn",
        "from nrp_auction_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.AuctionRecordMapper.BaseResultMap")
    AuctionRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuctionRecord record);

    @Update({
        "update nrp_auction_record",
        "set auction_plan_id = #{auctionPlanId,jdbcType=BIGINT},",
          "niuren_id = #{niurenId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "company = #{company,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AuctionRecord record);
}
