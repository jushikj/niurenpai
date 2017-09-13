package com.niurenpai.mapper.model;

import java.util.Date;

public class AuctionPlan {
    private Long id;

    private Long niurenId;

    private Date guessStartTime;

    private Date guessEndTime;

    private Date auctionEndTime;

    private Date createTime;

    private Date updateTime;

    private Integer city;

    private Integer job;

    private Integer status;

    private Integer yn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNiurenId() {
        return niurenId;
    }

    public void setNiurenId(Long niurenId) {
        this.niurenId = niurenId;
    }

    public Date getGuessStartTime() {
        return guessStartTime;
    }

    public void setGuessStartTime(Date guessStartTime) {
        this.guessStartTime = guessStartTime;
    }

    public Date getGuessEndTime() {
        return guessEndTime;
    }

    public void setGuessEndTime(Date guessEndTime) {
        this.guessEndTime = guessEndTime;
    }

    public Date getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Date auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
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

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
