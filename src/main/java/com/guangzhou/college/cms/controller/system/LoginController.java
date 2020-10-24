package com.guangzhou.college.cms.controller.system;

import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cms/system")
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public ResultInfo doLogin() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()){
            log.info("doLogin success.....");
            return new ResultInfo(ReturnCodeEnum.LOGIN_SUCCESS);
        } else {
            log.info("doLogin fail.....");
            return new ResultInfo(ReturnCodeEnum.LOGIN_ERROR);
        }
    }

    /**
     * 登录成功接口
     * @return
     */
    @RequestMapping(value = "/login/success")
    public Object loginSuccess() {
        ResultInfo resultInfo = new ResultInfo(ReturnCodeEnum.LOGIN_SUCCESS);
        log.info("-----------login success!");
        return resultInfo;
    }


    @RequestMapping(value = "/login/error")
    public Object loginError() {
        ResultInfo resultInfo = new ResultInfo(ReturnCodeEnum.LOGIN_ERROR);
        log.info("-----------login error!");
        return resultInfo;
    }
    /**
     * 退出接口
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Object logout() {
        ResultInfo resultInfo = new ResultInfo();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return resultInfo;
    }
}
