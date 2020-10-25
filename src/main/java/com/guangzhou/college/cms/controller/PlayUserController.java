package com.guangzhou.college.cms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guangzhou.college.cms.service.PlayUserService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.common.utils.MD5;
import com.guangzhou.college.common.utils.Md5Util;
import com.guangzhou.college.entity.PlayUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
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
@RequestMapping("/cms/playUser")
public class PlayUserController {

    @Autowired
    private PlayUserService playUserService;

    /**
     * 根据条件查询菜单列表
     * @param request
     * @return ResultInfo
     */
    @PostMapping(value = "/queryPlayUserList")
    public ResultInfo queryPlayUserList(HttpServletRequest request, @RequestBody Map<String,Object> params) {
        ResultInfo resultInfo = new ResultInfo();
        PlayUser PlayUser = new PlayUser();
        String userNo = String.valueOf(params.get("userNo"));
        if(!StringUtils.isEmpty(userNo)){
            PlayUser.setUserNo(Integer.valueOf(userNo));
        }
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNum"))),Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<PlayUser> list = playUserService.queryPlayUserList(PlayUser);
        PageInfo pageInfo = new PageInfo(list);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setTotal(pageInfo.getTotal());
        resultInfo.setData(list);
        return resultInfo;
    }


    /**
     * 添加记录
     * @param PlayUser
     * @return ResultInfo
     */
    @PostMapping(value = "/addPlayUser")
    public ResultInfo addPlayUser(@RequestBody PlayUser PlayUser) {
        PlayUser.setMd5Password(Md5Util.encryptMD5(PlayUser.getPassword()));
        playUserService.addPlayUser(PlayUser);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


    /**
     * 修改记录
     * @param PlayUser
     * @return ResultInfo
     */
    @PostMapping(value = "/eidtPlayUser")
    public ResultInfo eidtPlayUser(@RequestBody PlayUser PlayUser) {
        playUserService.eidtPlayUser(PlayUser);
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }



    /**
     * 单笔删除记录
     * @param PlayUser
     * @return ResultInfo
     */
    @PostMapping(value = "/delPlayUser")
    public ResultInfo delPlayUser(@RequestBody PlayUser PlayUser) {
        playUserService.delPlayUser(PlayUser.getId());
        return new ResultInfo(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
    }


}
