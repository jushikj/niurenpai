package com.niurenpai.mapper.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 用户
 * @author meng.haoran
 * @create 2017/9/13 15:58
 */
@Data
public class User implements Serializable{

    private long id;

    private String userId;

    private String mobile;

    private String name;

    private String nickName;

    private String headImgUrl;

    private String openId;

    private int status;

    private Date createTime;

    private Date updateTime;

    private int yn;

}
