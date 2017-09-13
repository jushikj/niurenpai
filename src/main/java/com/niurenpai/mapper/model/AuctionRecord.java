package com.niurenpai.mapper.model;

import java.math.BigDecimal;
import java.util.Date;

public class AuctionRecord {
    private Long id;

    private Long auctionPlanId;

    private Long niurenId;

    private String userId;

    private BigDecimal amount;

    private String company;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuctionPlanId() {
        return auctionPlanId;
    }

    public void setAuctionPlanId(Long auctionPlanId) {
        this.auctionPlanId = auctionPlanId;
    }

    public Long getNiurenId() {
        return niurenId;
    }

    public void setNiurenId(Long niurenId) {
        this.niurenId = niurenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
