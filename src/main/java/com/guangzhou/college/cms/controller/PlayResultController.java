package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.PlayResultService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.PlayResult;
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
@RequestMapping("/cms/playResult")
public class PlayResultController {

    @Autowired
    private PlayResultService playResultService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryPlayResultList")
    public ResultInfo queryplayResultList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        PlayResult playResult = new PlayResult();
        String userNo = String.valueOf(params.get("userNo"));
        String schoolId = String.valueOf(params.get("userNo"));
        if(!StringUtils.isEmpty(userNo)){
            playResult.setUserNo(userNo);
        }
        if(!StringUtils.isEmpty(schoolId)){
            playResult.setSchoolId(Integer.valueOf(schoolId));
        }
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<PlayResult> list = playResultService.queryPlayResultList(playResult);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param playResult
     * @return ResultInfo
     */
    @PostMapping(value = "/addPlayResult")
    public ResultInfo addplayResult(@RequestBody PlayResult playResult) {
        playResultService.addPlayResult(playResult);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param playResult
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtPlayResult")
    public ResultInfo eidtplayResult(@RequestBody PlayResult playResult) {
        playResultService.eidtPlayResult(playResult);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param playResult
     * @return ResultInfo
     */
    @PostMapping(value = "/delPlayResult")
    public ResultInfo delplayResult(@RequestBody PlayResult playResult) {
        playResultService.delPlayResult(playResult.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
