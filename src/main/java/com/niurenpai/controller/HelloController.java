package com.niurenpai.controller;

import com.niurenpai.mapper.dao.UserMapper;
import com.niurenpai.mapper.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meng.haoran
 * @create 2017/9/11 20:12
 */
@RestController
@EnableAutoConfiguration
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){

        User user = userMapper.getById(1);

        return user.toString();
    }
}
