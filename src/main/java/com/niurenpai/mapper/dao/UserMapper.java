package com.niurenpai.mapper.dao;

import com.niurenpai.mapper.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author meng.haoran
 * @create 2017/9/13 15:57
 */
@Mapper
public interface UserMapper {

    @Select("select * from nrp_user where id=#{id}")
    @ResultMap("com.niurenpai.mapper.UserMapper.UserMapperResult")
    User getById(long id);
}
