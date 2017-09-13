package com.niurenpai.mapper.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author meng.haoran
 * @create 2017/9/13 15:58
 */
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", openId='" + openId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", yn=" + yn +
                '}';
    }
}
