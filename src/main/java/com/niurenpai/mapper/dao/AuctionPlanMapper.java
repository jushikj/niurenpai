package com.niurenpai.mapper.dao;

import com.niurenpai.constant.dto.AuctionPlanData;
import com.niurenpai.mapper.model.AuctionPlan;
import org.apache.ibatis.annotations.*;

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
        "select",
        "id, niuren_id, guess_start_time, guess_end_time, auction_end_time, create_time, ",
        "update_time, city, job, status, yn",
        "from nrp_auction_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.AuctionPlanMapper.BaseResultMap")
    AuctionPlan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuctionPlan record);

    @Update({
        "update nrp_auction_plan",
        "set niuren_id = #{niurenId,jdbcType=BIGINT},",
          "guess_start_time = #{guessStartTime,jdbcType=TIMESTAMP},",
          "guess_end_time = #{guessEndTime,jdbcType=TIMESTAMP},",
          "auction_end_time = #{auctionEndTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "city = #{city,jdbcType=INTEGER},",
          "job = #{job,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "yn = #{yn,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AuctionPlan record);

    @Select({
            "select",
            "id, niuren_id, guess_start_time, guess_end_time, auction_end_time, create_time, ",
            "update_time, city, job, status, yn",
            "from nrp_auction_plan,nrp_niuren,nrp_city",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("dao.AuctionPlanMapper.BaseResultMap")
    List<AuctionPlanData> selectByPage(int city,int job,int startIndex,int pageSize);

}
