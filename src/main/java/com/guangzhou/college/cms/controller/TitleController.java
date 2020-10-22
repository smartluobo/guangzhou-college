package com.guangzhou.college.cms.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.TitleService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.Title;
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
@RequestMapping("/cms/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryTitleList")
    public ResultInfo queryTitleList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        Title title = new Title();
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<Title> list = titleService.queryTitleList(title);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param title
     * @return ResultInfo
     */
    @PostMapping(value = "/addTitle")
    public ResultInfo addTitle(@RequestBody Title title) {
        log.info("*** addTitle *** {}",title.toString());
        titleService.addTitle(title);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param title
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtTitle")
    public ResultInfo eidtTitle(@RequestBody Title title) {
        titleService.eidtTitle(title);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 单笔删除记录
     * @param title
     * @return ResultInfo
     */
    @PostMapping(value = "/delTitle")
    public ResultInfo delTitle(@RequestBody Title title) {
        titleService.delTitle(title.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }




}
