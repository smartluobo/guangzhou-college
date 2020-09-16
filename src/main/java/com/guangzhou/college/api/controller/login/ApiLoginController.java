package com.guangzhou.college.api.controller.login;


import com.guangzhou.college.api.service.login.ApiLoginService;
import com.guangzhou.college.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
@Slf4j
public class ApiLoginController {


    @Resource
    private ApiLoginService apiLoginService;



    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String,String> params){
        log.info("api user login call.....");
        String code = null;
        try {
            if (CollectionUtils.isEmpty(params)){
                return ResultInfo.newEmptyResultInfo();
            }
            boolean flag = apiLoginService.login(params);
            if (flag){
                return ResultInfo.newSuccessResultInfo();
            }else{
                return ResultInfo.newFailResultInfo("login fail...");
            }

        }catch (Exception e){
            log.error("login happen exception code : {}",code,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
