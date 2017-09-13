package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.NiuRen;
import org.apache.ibatis.annotations.*;

public interface NiuRenMapper {

    @Delete({
        "delete from nrp_niuren",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_niuren (id, introduction_img_url)",
        "values (#{id,jdbcType=BIGINT}, #{introductionImgUrl,jdbcType=VARCHAR})"
    })
    int insert(NiuRen record);

    int insertSelective(NiuRen record);

    @Select({
        "select",
        "id, introduction_img_url",
        "from nrp_niuren",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.NiuRenMapper.BaseResultMap")
    NiuRen selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NiuRen record);

    @Update({
        "update nrp_niuren",
        "set introduction_img_url = #{introductionImgUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NiuRen record);
}
