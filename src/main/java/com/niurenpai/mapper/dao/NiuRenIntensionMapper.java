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

    @Select({
        "select",
        "id, niuren_id, expect_job, current_city, target_city, current_salary, expect_salary, ",
        "entry_time, create_time, update_time, yn",
        "from nrp_niuren_intension",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenIntensionMapper.BaseResultMap")
    NiuRenIntension selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, niuren_id, expect_job, current_city, target_city, current_salary, expect_salary, ",
            "entry_time, create_time, update_time, yn",
            "from nrp_niuren_intension",
            "where niuren_id=#{niurenId} and yn=0 limit 1"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenIntensionMapper.BaseResultMap")
    NiuRenIntension selectByNiurenId(@Param("niurenId") String niurenId);
}