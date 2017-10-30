package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.Interview;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InterviewMapper {

    @Select({
            "select * ",
            "from nrp_interview",
            "where niuren_id=#{niurenId} and yn=0"
    })
    @ResultMap("com.niurenpai.mapper.dao.InterviewMapper.BaseResultMap")
    List<Interview> selectByNiuren(@Param("niurenId") long niurenId);
}
