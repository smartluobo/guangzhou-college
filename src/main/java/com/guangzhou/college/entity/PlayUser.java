package com.guangzhou.college.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.guangzhou.college.entity.comment.BaseEntity;
import lombok.Data;

@Data
public class PlayUser extends BaseEntity {


    private String md5Password;

    private String name;

    @JSONField(serialize = false)
    private String password;

    private Integer userNo;

}
