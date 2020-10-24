package com.guangzhou.college.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guangzhou.college.entity.comment.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Global extends BaseEntity {

    private String title;

    private String url;

    private String buttomPreview;

    private String buttomUse;

    private String phone;

    private String tel;

    private String qrCode;

    private String links;

    private String description;

    private String logo;



}
