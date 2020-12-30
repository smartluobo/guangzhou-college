package com.guangzhou.college.cms.controller.api;

import com.guangzhou.college.cms.service.PlayResultService;
import com.guangzhou.college.cms.service.PlayUserService;
import com.guangzhou.college.cms.service.StudenInfoService;
import com.guangzhou.college.cms.service.TravelResultService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.common.utils.JsonUtil;
import com.guangzhou.college.common.utils.Md5Util;
import com.guangzhou.college.common.utils.ValidateUtils;
import com.guangzhou.college.entity.PlayResult;
import com.guangzhou.college.entity.PlayUser;
import com.guangzhou.college.entity.StudenInfo;
import com.guangzhou.college.entity.TravelResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 接口调用Controller
 */
@Slf4j
@Controller
@RequestMapping("/download")
public class DownloadSchoolController {


    @Autowired
    private StudenInfoService studenInfoService;

    @RequestMapping(value="/download64" , method = RequestMethod.GET)
    public String download() {
        return "redirect:http://cms.eecup.cn:8099/download/64.zip";
    }




    @RequestMapping(value="/reciveAccount" , method = RequestMethod.GET)
    public String reciveAccount(HttpServletRequest request) {
        String code = request.getParameter("account");
        log.info("api uploadResult call....."+code );
        StudenInfo studenInfo = new StudenInfo();
        studenInfo.setAccount(code);
        studenInfo.setCreateTime(new Date());
        studenInfo.setSchool("广州大学");
        List<StudenInfo> studenInfos =  studenInfoService.selectListByPrimaryKey(studenInfo);
        if(studenInfos.size()==0){
            studenInfoService.insertSelective(studenInfo);
        }
        return "redirect:http://cms.eecup.cn:8078/about.html";
    }



}
