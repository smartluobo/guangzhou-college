package com.guangzhou.college.cms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.guangzhou.college.cms.service.GlobalService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.Global;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户Controller
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/cms/global")
public class GlobalController {

    @Autowired
    private GlobalService globalService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryGlobalList")
    public ResultInfo queryGlobalList(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        Integer page = StringUtils.isEmpty(request.getParameter("pageNum"))? 0: Integer.valueOf(request.getParameter("pageNum"));
        Integer limit = StringUtils.isEmpty(request.getParameter("pageSize"))? 10: Integer.valueOf(request.getParameter("pageSize"));
        Global Global = new Global();
        PageHelper.startPage(page,limit);
        List<Global> list = globalService.queryGlobalList(Global);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param Global
     * @return ResultInfo
     */
    @PostMapping(value = "/addGlobal")
    public ResultInfo addGlobal(@RequestBody Global Global) {
        globalService.addGlobal(Global);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param Global
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtGlobal")
    public ResultInfo eidtGlobal(@RequestBody Global Global) {
        log.info(Global.toString());
        globalService.eidtGlobal(Global);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 单笔删除记录
     * @param id
     * @return ResultInfo
     */
    @PostMapping(value = "/delGlobal")
    public ResultInfo delGlobal(@PathVariable int id) {
        globalService.delGlobal(id);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
