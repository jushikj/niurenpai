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

    @Select({
        "select",
        "id, niuren_id, company, job, start_date, end_date, work_life, create_time, update_time, ",
        "yn",
        "from nrp_niuren_workexp",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenWorkexpMapper.BaseResultMap")
    NiuRenWorkexp selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, niuren_id, company, job, start_date, end_date, work_life, create_time, update_time, ",
            "yn",
            "from nrp_niuren_workexp",
            "where niuren_id=#{niurenId} order by start_date"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenWorkexpMapper.BaseResultMap")
    List<NiuRenWorkexp> selectByNiurenId(@Param("niurenId") String niurenId);
}