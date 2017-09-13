package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.MoneyRecord;
import org.apache.ibatis.annotations.*;

public interface MoneyRecordMapper {

    @Delete({
        "delete from nrp_money_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_money_record (id, user_id, ",
        "busi_type, busi_desc, ",
        "amount, total_amount, ",
        "status, create_time, ",
        "update_time, yn)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=VARCHAR}, ",
        "#{busiType,jdbcType=INTEGER}, #{busiDesc,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DECIMAL}, #{totalAmount,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{yn,jdbcType=INTEGER})"
    })
    int insert(MoneyRecord record);

    int insertSelective(MoneyRecord record);

    @Select({
        "select",
        "id, user_id, busi_type, busi_desc, amount, total_amount, status, create_time, ",
        "update_time, yn",
        "from nrp_money_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.MoneyRecordMapper.BaseResultMap")
    MoneyRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MoneyRecord record);

    @Update({
        "update nrp_money_record",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "busi_type = #{busiType,jdbcType=INTEGER},",
          "busi_desc = #{busiDesc,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MoneyRecord record);
}
