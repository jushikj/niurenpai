package com.niurenpai.controller.api;

import com.niurenpai.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author meng.haoran
 * @create 2017/9/13 20:59
 */
@RestController
@EnableAutoConfiguration
public class CoreController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    CoreService coreService;

    @RequestMapping("/niurenpai/index")
    @ResponseBody
    public String index() {

        //分页查询竞拍计划列表

        return null;
    }

    @RequestMapping("/niurenpai/niuren/detail")
    @ResponseBody
    public String niurenDetail() {
        return null;
    }



}
