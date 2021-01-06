package com.guangzhou.college.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TravelResult {

    private int id;

    private String code;

    private String totalScore;

    private String yuyueScore;

    private String xianzhirenliuScore;

    private String fengxianshibieScore;

    private String caitashijianScore;

    private String fashenghuozaiScore;

    private String kaoheScore;

    private String jiancemudiScore;

    private String miehuoScore;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String school;


}
