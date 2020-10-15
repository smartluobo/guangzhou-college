package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.VideoService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.Video;
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
@RequestMapping("/cms/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryVideoList")
    public ResultInfo queryVideoList(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        Integer page = StringUtils.isEmpty(request.getParameter("pageNum"))? 0: Integer.valueOf(request.getParameter("pageNum"));
        Integer limit = StringUtils.isEmpty(request.getParameter("pageSize"))? 10: Integer.valueOf(request.getParameter("pageSize"));
        Video Video = new Video();
        PageHelper.startPage(page,limit);
        List<Video> list = videoService.queryVideoList(Video);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param Video
     * @return ResultInfo
     */
    @PostMapping(value = "/addVideo")
    public ResultInfo addVideo(@RequestBody Video Video) {
        videoService.addVideo(Video);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param Video
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtVideo")
    public ResultInfo eidtVideo(@RequestBody Video Video) {
        videoService.eidtVideo(Video);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 单笔删除记录
     * @param id
     * @return ResultInfo
     */
    @PostMapping(value = "/delVideo")
    public ResultInfo delVideo(@PathVariable int id) {
        videoService.delVideo(id);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }

}
