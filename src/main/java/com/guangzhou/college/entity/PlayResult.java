package com.guangzhou.college.entity;

import com.guangzhou.college.entity.comment.BaseEntity;
import lombok.Data;



@Data
public class PlayResult extends BaseEntity {

    private String userNo;

    private Integer result;


}