package com.niurenpai.mapper.dao;

import java.util.List;

import com.niurenpai.mapper.model.NiuRenAuth;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NiuRenAuthMapper {

    @Delete({
        "delete from nrp_niuren_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_niuren_auth (id, niuren_id, ",
        "info_verfy, spec_skill, ",
        "behave, job_rank, ",
        "create_time, update_time, ",
        "yn)",
        "values (#{id,jdbcType=BIGINT}, #{niurenId,jdbcType=BIGINT}, ",
        "#{infoVerfy,jdbcType=VARCHAR}, #{specSkill,jdbcType=VARCHAR}, ",
        "#{behave,jdbcType=VARCHAR}, #{jobRank,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{yn,jdbcType=INTEGER})"
    })
    int insert(NiuRenAuth record);

    @Select({
        "select",
        "id, niuren_id, info_verfy, spec_skill, behave, job_rank, create_time, update_time, ",
        "yn",
        "from nrp_niuren_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.NiuRenAuthMapper.BaseResultMap")
    NiuRenAuth selectByPrimaryKey(Long id);

    @Update({
        "update nrp_niuren_auth",
        "set niuren_id = #{niurenId,jdbcType=BIGINT},",
          "info_verfy = #{infoVerfy,jdbcType=VARCHAR},",
          "spec_skill = #{specSkill,jdbcType=VARCHAR},",
          "behave = #{behave,jdbcType=VARCHAR},",
          "job_rank = #{jobRank,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NiuRenAuth record);
}