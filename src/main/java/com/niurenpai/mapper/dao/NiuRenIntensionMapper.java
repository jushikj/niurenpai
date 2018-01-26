package com.niurenpai.mapper.dao;

import java.util.List;

import com.niurenpai.mapper.model.NiuRenIntension;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NiuRenIntensionMapper {

    @Delete({
        "delete from nrp_niuren_intension",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_niuren_intension (id, niuren_id, ",
        "expect_job, current_city, ",
        "target_city, current_salary, ",
        "expect_salary, entry_time, ",
        "create_time, update_time, ",
        "yn)",
        "values (#{id,jdbcType=BIGINT}, #{niurenId,jdbcType=BIGINT}, ",
        "#{expectJob,jdbcType=VARCHAR}, #{currentCity,jdbcType=VARCHAR}, ",
        "#{targetCity,jdbcType=VARCHAR}, #{currentSalary,jdbcType=VARCHAR}, ",
        "#{expectSalary,jdbcType=VARCHAR}, #{entryTime,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{yn,jdbcType=INTEGER})"
    })
    int insert(NiuRenIntension record);

    @Select({
        "select",
        "id, niuren_id, expect_job, current_city, target_city, current_salary, expect_salary, ",
        "entry_time, create_time, update_time, yn",
        "from nrp_niuren_intension",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.NiuRenIntensionMapper.BaseResultMap")
    NiuRenIntension selectByPrimaryKey(Long id);


    @Update({
        "update nrp_niuren_intension",
        "set niuren_id = #{niurenId,jdbcType=BIGINT},",
          "expect_job = #{expectJob,jdbcType=VARCHAR},",
          "current_city = #{currentCity,jdbcType=VARCHAR},",
          "target_city = #{targetCity,jdbcType=VARCHAR},",
          "current_salary = #{currentSalary,jdbcType=VARCHAR},",
          "expect_salary = #{expectSalary,jdbcType=VARCHAR},",
          "entry_time = #{entryTime,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NiuRenIntension record);
}