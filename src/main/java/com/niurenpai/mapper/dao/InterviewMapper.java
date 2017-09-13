package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.Interview;
import org.apache.ibatis.annotations.*;

public interface InterviewMapper {

    @Delete({
        "delete from nrp_interview",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_interview (id, niuren_id, ",
        "question, answer)",
        "values (#{id,jdbcType=BIGINT}, #{niurenId,jdbcType=BIGINT}, ",
        "#{question,jdbcType=VARCHAR}, #{answer,jdbcType=VARCHAR})"
    })
    int insert(Interview record);

    int insertSelective(Interview record);

    @Select({
        "select",
        "id, niuren_id, question, answer",
        "from nrp_interview",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.InterviewMapper.BaseResultMap")
    Interview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Interview record);

    @Update({
        "update nrp_interview",
        "set niuren_id = #{niurenId,jdbcType=BIGINT},",
          "question = #{question,jdbcType=VARCHAR},",
          "answer = #{answer,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Interview record);
}
