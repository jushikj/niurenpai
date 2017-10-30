package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.NiuRen;
import org.apache.ibatis.annotations.*;

public interface NiuRenMapper {

    @Select({
        "select * ",
        "from nrp_niuren",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.NiuRenMapper.BaseResultMap")
    NiuRen selectByPrimaryKey(Long id);

}
