package com.guangzhou.college.entity;

import com.guangzhou.college.entity.comment.BaseEntity;
import lombok.Data;

@Data
public class PlayUser extends BaseEntity {


    private String name;

    private String password;

    private Integer userNo;

}
