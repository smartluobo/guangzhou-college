package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.TravelResultService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.TravelResult;
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
@RequestMapping("/cms/travelResult")
public class TravelResultController {

    @Autowired
    private TravelResultService travelResultService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryTravelResultList")
    public ResultInfo queryTravelResultList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        TravelResult travelResult = new TravelResult();
        String userNo = String.valueOf(params.get("userNo"));
        if(!StringUtils.isEmpty(userNo)){
            travelResult.setCode(userNo);
        }

        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<TravelResult> list = travelResultService.selectListByPrimaryKey(travelResult);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }

    

    /**
     * 添加记录
     * @param TravelResult
     * @return ResultInfo
     */
    @PostMapping(value = "/addTravelResult")
    public ResultInfo addTravelResult(@RequestBody TravelResult TravelResult) {
        travelResultService.insertSelective(TravelResult);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param TravelResult
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtTravelResult")
    public ResultInfo eidtTravelResult(@RequestBody TravelResult TravelResult) {
        travelResultService.updateByPrimaryKeySelective(TravelResult);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param TravelResult
     * @return ResultInfo
     */
    @PostMapping(value = "/delTravelResult")
    public ResultInfo delTravelResult(@RequestBody TravelResult TravelResult) {
        travelResultService.deleteByPrimaryKey(TravelResult.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
