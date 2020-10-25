package com.guangzhou.college.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guangzhou.college.entity.comment.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Article extends BaseEntity {

    private String icon;

    private String name;

    private Integer sort;

    private String title;

    private String content;

    private String htmlContent;
}
