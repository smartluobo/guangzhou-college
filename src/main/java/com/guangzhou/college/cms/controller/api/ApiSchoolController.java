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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 接口调用Controller
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiSchoolController {


    @Autowired
    private PlayUserService playUserService;

    @Autowired
    private PlayResultService playResultService;

    @Autowired
    private TravelResultService travelResultService;

    @Autowired
    private StudenInfoService studenInfoService;


    /**
     * 登录接口
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/login")
    public ResultInfo login(@RequestBody Map<String,Object> params) throws Exception {
        String message = "";
        ResultInfo resultInfo = new ResultInfo();
        log.info("*** ApiSchoolController login*** {}", JsonUtil.mapToJson(params));
        String userNo = String.valueOf(params.get("userNo"));
        String password = String.valueOf(params.get("password"));
        String schoolId = String.valueOf(params.get("schoolId"));

        if(StringUtils.isEmpty(userNo)){
            message = "学生学号不能为空";
        }
        if(StringUtils.isEmpty(password)){
            message = "密码不能为空";
        }
        if(StringUtils.isEmpty(schoolId)){
            message = "学校编码ID不能为空";
        }
        try {
            PlayUser playUser = new PlayUser();
            playUser.setUserNo(Integer.valueOf(userNo));
            playUser.setSchoolId(Integer.valueOf(schoolId));
            List<PlayUser> playUserList = playUserService.queryPlayUserList(playUser);
            if(playUserList.size()>0){
                playUser = playUserList.get(0);
                log.info("*** password ***->{}",Md5Util.encryptMD5(password));
                if(!playUser.getPassword().equals(Md5Util.encryptMD5(password))){
                    message = "您输入的密码不正确！";
                }
            }else{
                message = "您输入的用户名不存在！";
            }
            if(StringUtils.isEmpty(message)){
                resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
                resultInfo.setData(playUser);
            }else{
                resultInfo.setCode(ReturnCodeEnum.VERIFICATION_FAILED.getStatus());
                resultInfo.setMsg(message);
            }
        } catch (NumberFormatException e) {
            resultInfo.setCode(ReturnCodeEnum.PARAMETER_TYPE_ERROR.getStatus());
            resultInfo.setMsg(message);
            return resultInfo;
        }
        return resultInfo;
    }




    /**
     * 登录接口
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/addGrades")
    public ResultInfo addGrades(@RequestBody Map<String,Object> params) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        log.info("*** ApiSchoolController addGrades*** {}", JsonUtil.mapToJson(params));
        String message = "";
        String userNo = String.valueOf(params.get("userNo"));
        String result = String.valueOf(params.get("result"));
        String schoolId = String.valueOf(params.get("schoolId"));

        if(StringUtils.isEmpty(userNo)){
            message = "学生学号不能为空";
        }
        if(StringUtils.isEmpty(result)){
            message = "分数不能为空";
        }
        if(StringUtils.isEmpty(schoolId)){
            message = "学校编码ID不能为空";
        }
        if (!ValidateUtils.scoreIntervalValidate(Integer.valueOf(result))){
            message = "成绩的分数必须在0到100分之内";
        }
        if(!existUserNo(Integer.valueOf(userNo),Integer.valueOf(schoolId))){
            message = "学号:"+userNo+"不存在";
        }
        if(StringUtils.isEmpty(message)){
            PlayResult playResult = new PlayResult();
            playResult.setSchoolId(Integer.valueOf(schoolId));
            playResult.setResult(Integer.valueOf(result));
            playResult.setUserNo(userNo);
            playResultService.addPlayResult(playResult);
            resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        }else{
            resultInfo.setCode(ReturnCodeEnum.VERIFICATION_FAILED.getStatus());
            resultInfo.setMsg(message);
        }
        return resultInfo;
    }




    /**
     * 登录接口
     * @param params
     * @return ResultInfo
     */
    @PostMapping(value = "/addImgOfGrades")
    public ResultInfo addImgOfGrades(@RequestBody Map<String,Object> params) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        log.info("*** ApiSchoolController addGrades*** {}", JsonUtil.mapToJson(params));
        String userNo = String.valueOf(params.get("userNo"));
        String image = String.valueOf(params.get("image"));
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        resultInfo.setData(params);
        return resultInfo;
    }





    //判断是否存在这个学号
    private boolean existUserNo(Integer userNo,Integer schoolId){
        PlayUser playUser = new PlayUser();
        playUser.setSchoolId(schoolId);
        playUser.setUserNo(userNo);
        List<PlayUser> playUserList = playUserService.queryPlayUserList(playUser);
        if(playUserList.size()>0){
            return true;
        }else{
            return false;
        }
    }



    /******************** 广州大学旅游学院 start ********************/



    @PostMapping("/uploadResult")
    public ResultInfo uploadResult(@RequestBody Map<String,String> params){
        log.info("api uploadResult call.....");
        String code = null;
        try {
            log.info(params.toString());
            TravelResult travelResult = new TravelResult();

            String account = String.valueOf(params.get("account"));
            if(StringUtils.isEmpty(account)){
                return ResultInfo.newFailResultInfo("学号不能为空");
            }
            StudenInfo studenInfo = new StudenInfo();
            studenInfo.setAccount(account);
            List<StudenInfo> studenInfos =  studenInfoService.selectListByPrimaryKey(studenInfo);
            if(studenInfos.size()==0){
                return ResultInfo.newFailResultInfo("学号不存在");
            }
            travelResult.setCode(account);
            travelResult.setTotalScore(String.valueOf(params.get("totalScore")));
            travelResult.setYuyueScore(String.valueOf(params.get("yuyueScore")));
            travelResult.setXianzhirenliuScore(String.valueOf(params.get("xianzhirenliuScore")));
            travelResult.setFengxianshibieScore(String.valueOf(params.get("fengxianshibieScore")));
            travelResult.setCaitashijianScore(String.valueOf(params.get("caitashijianScore")));
            travelResult.setFashenghuozaiScore(String.valueOf(params.get("fashenghuozaiScore")));
            travelResult.setKaoheScore(String.valueOf(params.get("kaoheScore")));
            travelResult.setJiancemudiScore(String.valueOf(params.get("jiancemudiScore")));
            travelResult.setMiehuoScore(String.valueOf(params.get("miehuoScore")));
            travelResult.setCreateTime(new Date());
            travelResult.setSchool(String.valueOf(params.get("service")));
            log.info(travelResult.toString());
            travelResultService.insertSelective(travelResult);
            return ResultInfo.newSuccessResultInfo();
        }catch (Exception e){
            log.error("login happen exception code : {}",code,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }




    @PostMapping("/booleanAccounts")
    public ResultInfo booleanCode(@RequestBody Map<String,String> params){
        log.info("api uploadResult call.....");
        String code = null;
        try {
            log.info(params.toString());
            String account = String.valueOf(params.get("account"));
            StudenInfo studenInfo = new StudenInfo();
            studenInfo.setAccount(account);
            List<StudenInfo> studenInfos =  studenInfoService.selectListByPrimaryKey(studenInfo);
            if(studenInfos.size()>0){
                return ResultInfo.newSuccessResultInfo();
            }else{
                return ResultInfo.newFailResultInfo("http://8.129.214.63:8066/login");
            }
        }catch (Exception e){
            log.error("login happen exception code : {}",code,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }



    @GetMapping("/saveAccount")
    public ResultInfo saveAccount(HttpServletRequest request){
        log.info("api uploadResult call.....");
        String code = request.getParameter("account");
        try {
            log.info("api uploadResult call....."+code );
            StudenInfo studenInfo = new StudenInfo();
            studenInfo.setAccount(code);
            studenInfo.setCreateTime(new Date());
            studenInfo.setSchool("广州大学");
            List<StudenInfo> studenInfos =  studenInfoService.selectListByPrimaryKey(studenInfo);
            if(studenInfos.size() ==0){
                studenInfoService.insertSelective(studenInfo);
            }
            return ResultInfo.newSuccessResultInfo();
        }catch (Exception e){
            log.error("login happen exception code : {}",code,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }



    @RequestMapping(value="/download" , method = RequestMethod.GET)
    public String download() {
        return "redirect:http://cms.eecup.cn:8099/download/64.zip";
    }

    /******************** 广州大学旅游学院 end ********************/













}
