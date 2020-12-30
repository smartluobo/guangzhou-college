package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.StudenInfoService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.common.utils.Md5Util;
import com.guangzhou.college.entity.StudenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/cms/studenInfo")
public class StudenInfoController {

    @Autowired
    private StudenInfoService studenInfoService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryStudenInfoList")
    public ResultInfo queryStudenInfoList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        StudenInfo studenInfo = new StudenInfo();
        String userNo = String.valueOf(params.get("userNo"));
        if(!StringUtils.isEmpty(userNo)){
            studenInfo.setAccount(userNo);
        }
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<StudenInfo> list = studenInfoService.selectListByPrimaryKey(studenInfo);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param studenInfo
     * @return ResultInfo
     */
    @PostMapping(value = "/addStudenInfo")
    public ResultInfo addStudenInfo(@RequestBody StudenInfo studenInfo) {
//        StudenInfo.setMd5Password(Md5Util.encryptMD5(StudenInfo.getPassword()));
//        StudenInfoService.addStudenInfo(StudenInfo);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param studenInfo
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtStudenInfo")
    public ResultInfo eidtStudenInfo(@RequestBody StudenInfo studenInfo) {
        studenInfoService.updateByPrimaryKeySelective(studenInfo);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param studenInfo
     * @return ResultInfo
     */
    @PostMapping(value = "/delStudenInfo")
    public ResultInfo delStudenInfo(@RequestBody StudenInfo studenInfo) {
        studenInfoService.deleteByPrimaryKey(studenInfo.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
