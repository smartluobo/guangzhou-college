package com.guangzhou.college.entity.wechat;


import lombok.Data;

@Data
public class WxGetUserInfoParam {

    private String encryptedData;

    private String sessionKey;

    private String iv;

}
