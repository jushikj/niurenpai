package com.niurenpai.mapper.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class NiuRenAuth {
    private Long id;

    private String niurenId;

    private String infoVerfy;

    private String specSkill;

    private String behave;

    private String jobRank;

    private Date createTime;

    private Date updateTime;

    private Integer yn;

}