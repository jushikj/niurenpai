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


    @Select({
        "select",
        "id, niuren_id, info_verfy, spec_skill, behave, job_rank, create_time, update_time, ",
        "yn",
        "from nrp_niuren_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenAuthMapper.BaseResultMap")
    NiuRenAuth selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, niuren_id, info_verfy, spec_skill, behave, job_rank, create_time, update_time, ",
            "yn",
            "from nrp_niuren_auth",
            "where niuren_id=#{niurenId} and yn=0 limit 1"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenAuthMapper.BaseResultMap")
    NiuRenAuth selectByNiurenId(@Param("niurenId") String niurenId);
}