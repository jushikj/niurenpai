package com.niurenpai.constant.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author meng.haoran
 * @create 2017/10/30 15:01
 */
@Data
public class ResultData implements Serializable{

    private int status;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    private ResultData(){}

    public static ResultData newInstance() {

        ResultData resultData = new ResultData();
        resultData.setStatus(0);
        resultData.setMessage("ok");
        return resultData;
    }

    public void addData(String key, Object value) {
        if (org.springframework.util.StringUtils.isEmpty(key)) {
            return;
        }
        if (value == null) {
            data.put(key, new HashMap<>());
        }
        data.put(key, value);
    }

}
