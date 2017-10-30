package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.UserAccount;
import org.apache.ibatis.annotations.*;

public interface UserAccountMapper {

    @Insert({
        "insert into nrp_user_account (id, user_id, ",
        "total_amount, status, ",
        "create_time, update_time, ",
        "yn)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=VARCHAR}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{yn,jdbcType=INTEGER})"
    })
    int insert(UserAccount record);

    @Select({
        "select",
        "id, user_id, total_amount, status, create_time, update_time, yn",
        "from nrp_user_account",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.UserAccountMapper.BaseResultMap")
    UserAccount selectByPrimaryKey(Long id);

    @Update({
        "update nrp_user_account",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserAccount record);
}
