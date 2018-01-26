package com.niurenpai.mapper.dao;

import java.util.List;

import com.niurenpai.mapper.model.NiuRenWorkexp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NiuRenWorkexpMapper {

    @Delete({
        "delete from nrp_niuren_workexp",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_niuren_workexp (id, niuren_id, ",
        "company, job, start_date, ",
        "end_date, work_life, ",
        "create_time, update_time, ",
        "yn)",
        "values (#{id,jdbcType=BIGINT}, #{niurenId,jdbcType=BIGINT}, ",
        "#{company,jdbcType=VARCHAR}, #{job,jdbcType=VARCHAR}, #{startDate,jdbcType=DATE}, ",
        "#{endDate,jdbcType=DATE}, #{workLife,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{yn,jdbcType=INTEGER})"
    })
    int insert(NiuRenWorkexp record);

    @Select({
        "select",
        "id, niuren_id, company, job, start_date, end_date, work_life, create_time, update_time, ",
        "yn",
        "from nrp_niuren_workexp",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.NiuRenWorkexpMapper.BaseResultMap")
    NiuRenWorkexp selectByPrimaryKey(Long id);

    @Update({
        "update nrp_niuren_workexp",
        "set niuren_id = #{niurenId,jdbcType=BIGINT},",
          "company = #{company,jdbcType=VARCHAR},",
          "job = #{job,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "work_life = #{workLife,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NiuRenWorkexp record);
}