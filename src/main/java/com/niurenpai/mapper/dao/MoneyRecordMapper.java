package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.MoneyRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MoneyRecordMapper {

    @Select({
            "select * ",
            "from nrp_money_record",
            "where open_id=#{openId} and yn=0 order by id desc"
    })
    @ResultMap("com.niurenpai.mapper.dao.MoneyRecordMapper.BaseResultMap")
    List<MoneyRecord> selectByOpenId(@Param("openId") String openId);
}
