package com.guangzhou.college.cms.controller.api;

import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.common.utils.JsonUtil;
import com.guangzhou.college.entity.PlayUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 接口调用Controller
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiSchoolController {


    /**
     * 登录接口
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/login")
    public ResultInfo login(@RequestBody Map<String,Object> params) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        log.info("*** ApiSchoolController login*** {}", JsonUtil.mapToJson(params));

        PlayUser playUser = new PlayUser();

        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        return resultInfo;
    }




    /**
     * 登录接口
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/addGrades")
    public ResultInfo addGrades(@RequestBody Map<String,Object> params) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        log.info("*** ApiSchoolController addGrades*** {}", JsonUtil.mapToJson(params));

        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        return resultInfo;
    }


}
