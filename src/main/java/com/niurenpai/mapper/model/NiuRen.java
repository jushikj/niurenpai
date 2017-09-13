package com.niurenpai.mapper.model;

import java.util.Date;

public class NiuRen {
    private Long id;

    private String introductionImgUrl;

    private String name;

    private String nickName;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroductionImgUrl() {
        return introductionImgUrl;
    }

    public void setIntroductionImgUrl(String introductionImgUrl) {
        this.introductionImgUrl = introductionImgUrl;
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

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
