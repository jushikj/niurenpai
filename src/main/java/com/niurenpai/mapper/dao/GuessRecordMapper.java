package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.GuessRecord;
import org.apache.ibatis.annotations.*;

public interface GuessRecordMapper {

    @Delete({
        "delete from nrp_guess_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_guess_record (id, auction_plan_id, ",
        "niuren_id, user_id, ",
        "amount, create_time, ",
        "update_time, status, ",
        "yn)",
        "values (#{id,jdbcType=BIGINT}, #{auctionPlanId,jdbcType=BIGINT}, ",
        "#{niurenId,jdbcType=BIGINT}, #{userId,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{yn,jdbcType=INTEGER})"
    })
    int insert(GuessRecord record);

    int insertSelective(GuessRecord record);

    @Select({
        "select",
        "id, auction_plan_id, niuren_id, user_id, amount, create_time, update_time, status, ",
        "yn",
        "from nrp_guess_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.GuessRecordMapper.BaseResultMap")
    GuessRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuessRecord record);

    @Update({
        "update nrp_guess_record",
        "set auction_plan_id = #{auctionPlanId,jdbcType=BIGINT},",
          "niuren_id = #{niurenId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GuessRecord record);
}
