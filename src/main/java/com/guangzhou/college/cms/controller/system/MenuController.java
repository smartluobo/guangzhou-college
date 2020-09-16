package com.guangzhou.college.cms.controller.system;

import com.aliyuncs.utils.CacheTimeHelper;
import com.guangzhou.college.cms.service.system.SysMenuService;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.entity.system.SysMenuRequest;
import com.guangzhou.college.entity.system.SysMenuTree;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 菜单Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/cms/system")
@Slf4j
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 根据id查询用户菜单信息
     * @param menuId
     * @return
     */
    @RequiresPermissions("sys:menu:view")
    @RequestMapping(value = "/getSysMenuById")
    public Object getUserInfo(String menuId) {
        try {
            log.info("getUserInfo menuId : {}",menuId);
            ResultInfo resultInfo = new ResultInfo();
            if (StringUtils.isBlank(menuId)) {
                return  ResultInfo.newEmptyParamsResultInfo();
            }
            resultInfo.setData(sysMenuService.getSysMenuById(Integer.valueOf(menuId)));
            return resultInfo;
        }catch (Exception e){
            log.error("getUserInfo menuId : {} happen exception",menuId,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 查询所有的菜单信息
     * @return
     */
    @RequiresPermissions("sys:menu:view")
    @RequestMapping(value = "/getAllSysMenu")
    public Object getAllSysMenu(String menuId) {
        try {
            log.info("getAllSysMenu menuId : {}",menuId);
            ResultInfo resultInfo = new ResultInfo();
            if (StringUtils.isBlank(menuId)) {
                return ResultInfo.newEmptyResultInfo();
            }
            SysMenuTree menuTree = sysMenuService.querySysMenuTree(menuId, false);
            resultInfo.setData(menuTree);
            return resultInfo;
        }catch (Exception e ){
            log.error("getAllSysMenu menuId : {} happen exception ",menuId,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 保存菜单信息
     * @param sysMenuRequest
     * @return
     */
    @RequiresPermissions("sys:menu:edit")
    @RequestMapping(value = "/saveSysMenu")
    public Object saveSysMenu(@RequestBody SysMenuRequest sysMenuRequest) {
        try {
            log.info("saveSysMenu sysMenuRequest : {}",sysMenuRequest);
            ResultInfo resultInfo = new ResultInfo();
            if (null == sysMenuRequest) {
                return ResultInfo.newEmptyParamsResultInfo();
            }
            if (null == sysMenuRequest.getParent()){
                return ResultInfo.newEmptyParamsResultInfo();
            }
            sysMenuService.saveSysMenu(sysMenuRequest);
            return resultInfo;
        }catch (Exception e){
            log.error("saveSysMenu sysMenuRequest : {}",sysMenuRequest,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 修改菜单信息
     * @param sysMenuRequest
     * @return
     */
    @RequiresPermissions("sys:menu:edit")
    @RequestMapping(value = "/updateSysMenu")
    public Object updateSysMenu(@RequestBody SysMenuRequest sysMenuRequest) {
        try {
            log.info("updateSysMenu sysMenuRequest : {}",sysMenuRequest);
            ResultInfo resultInfo = new ResultInfo();
            if (null == sysMenuRequest) {
                return ResultInfo.newEmptyParamsResultInfo();
            }
            if (null == sysMenuRequest.getParent()){
                return ResultInfo.newEmptyParamsResultInfo();
            }
            sysMenuService.updateSysMenu(sysMenuRequest);
            return resultInfo;
        }catch (Exception e){
            log.error("updateSysMenu sysMenuRequest : {}",sysMenuRequest,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    @RequiresPermissions("sys:menu:edit")
    @RequestMapping(value = "/deleteSysMenu")
    public Object deleteSysMenu(String menuId) {
        try {
            log.info("deleteSysMenu menuId : {}",menuId );
            ResultInfo resultInfo = new ResultInfo();
            if (StringUtils.isBlank(menuId)) {
                return ResultInfo.newEmptyParamsResultInfo();
            }
            //root菜单不能被删除
            if (Integer.valueOf(menuId) == 1){
                return new ResultInfo(ReturnCodeEnum.ROOT_MENU_CAN_NOT_DELETE);
            }
            sysMenuService.deleteSysMenu(Integer.valueOf(menuId));
            return resultInfo;
        }catch (Exception e){
            log.error("deleteSysMenu menuId : {}",menuId ,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 获取树形结构
     * @param menuId
     * @return
     */
    @RequiresUser
    @RequestMapping(value = "/getSysMenuTree")
    public Object getSysMenuTree(String menuId) {
        try {
            log.info("getSysMenuTree menuId :{}",menuId);
            ResultInfo resultInfo = new ResultInfo();
            if (StringUtils.isBlank(menuId)) {
                return ResultInfo.newEmptyParamsResultInfo();
            }
            SysMenuTree menuTree = sysMenuService.querySysMenuTree(menuId, false);
            resultInfo.setData(menuTree);
            return resultInfo;
        }catch (Exception e){
            log.error("getSysMenuTree menuId :{}",menuId,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 根据用户获取菜单树
     * @return
     */
    @RequiresUser
    @RequestMapping(value = "/getSysMenuTreeByUser")
    public Object getSysMenuTreeByUser() {
        try {
            log.info("getSysMenuTreeByUser.....");
            ResultInfo resultInfo = new ResultInfo();
            SysMenuTree menuTree = sysMenuService.querySysMenuTree(null, false);
            resultInfo.setData(menuTree);
            return resultInfo;
        } catch (Exception e){
            log.info("getSysMenuTreeByUser.....",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }


    /**
     * 根据菜单获取菜单的按钮权限
     * @param menuId
     * @return
     */
    @RequiresUser
    @RequestMapping(value = "/getSysMenuAuthor")
    public Object getSysMenuAuthor(String menuId) {
        try {
            log.info("getSysMenuAuthor menuId : {}",menuId);
            ResultInfo resultInfo = new ResultInfo();
            if (StringUtils.isBlank(menuId)) {
                return ResultInfo.newEmptyParamsResultInfo();
            }
            List<Map<String, String>> authorList = sysMenuService.getSysMenuAuthor(menuId);
            resultInfo.setData(authorList);
            return resultInfo;
        }catch (Exception e){
            log.error("getSysMenuAuthor menuId : {}",menuId,e);
            return ResultInfo.newExceptionResultInfo();
        }

    }
}
