package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.AuctionPlan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuctionPlanMapper {

    @Delete({
        "delete from nrp_auction_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into nrp_auction_plan (id, niuren_id, ",
        "guess_start_time, guess_end_time, ",
        "auction_end_time, create_time, ",
        "update_time, city, ",
        "job, status, yn)",
        "values (#{id,jdbcType=BIGINT}, #{niurenId,jdbcType=BIGINT}, ",
        "#{guessStartTime,jdbcType=TIMESTAMP}, #{guessEndTime,jdbcType=TIMESTAMP}, ",
        "#{auctionEndTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{city,jdbcType=INTEGER}, ",
        "#{job,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{yn,jdbcType=INTEGER})"
    })
    int insert(AuctionPlan record);

    int insertSelective(AuctionPlan record);

    @Select({
        "select * ",
        "from nrp_auction_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.niurenpai.mapper.dao.AuctionPlanMapper.BaseResultMap")
    AuctionPlan selectByPrimaryKey(Long id);

    @Select({
            "select * ",
            "from nrp_auction_plan",
            "where yn=0 order by id desc"
    })
    @ResultMap("com.niurenpai.mapper.dao.AuctionPlanMapper.BaseResultMap")
    List<AuctionPlan> selectAll();
}
