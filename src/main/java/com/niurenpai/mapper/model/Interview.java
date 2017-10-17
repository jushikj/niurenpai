package com.niurenpai.mapper.model;

import lombok.Data;

/**
 * 面试问答
 */
@Data
public class Interview {
    private Long id;
    /**
     * 牛人id
     */
    private Long niurenId;
    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;

}
