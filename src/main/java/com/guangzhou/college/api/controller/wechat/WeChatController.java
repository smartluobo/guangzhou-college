package com.guangzhou.college.api.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.ReturnCodeEnum;
import com.guangzhou.college.common.utils.AesUtil;
import com.guangzhou.college.common.utils.HttpUtil;
import com.guangzhou.college.common.utils.WeChatUtils;
import com.guangzhou.college.entity.wechat.WxGetUserInfoParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("api/wechat")
public class WeChatController {


    @Value("${wxConfig.wxspAppid}")
    private String wxspAppid;

    @Value("${wxConfig.wxspSecret}")
    private String wxspSecret;

    @Value("${wxConfig.grantType}")
    private String grantType;



    @RequestMapping("/getUserPhone")
    private ResultInfo getUserPhone(@RequestBody WxGetUserInfoParam wxDecrypt){
        ResultInfo resultInfo = new ResultInfo();
        WeChatUtils.wxDecrypt(wxDecrypt.getEncryptedData(),wxDecrypt.getSessionKey(),wxDecrypt.getIv());
        return resultInfo;
    }



    //@ApiOperation("获取微信小程序的openid")
    //@ResponseBody
    @GetMapping(value = "/getOpenid")
    public ResultInfo getOpenid(String code) throws Exception{
        ResultInfo resultInfo = new ResultInfo();

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            return ResultInfo.newFailResultInfo("code不能为空");
        }
        //小程序唯一标识   (在微信小程序管理后台获取)
//        String wxspAppid = "************";
//        //小程序的 app secret (在微信小程序管理后台获取)
//        String wxspSecret = "************";
//        //授权（必填）  一般都是这个 可不用改
//        String grant_type = "authorization_code";
        //1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        Map<String,Object> params = new HashMap<>();
        params.put("appid",wxspAppid);
        params.put("secret",wxspSecret);
        params.put("js_code",code);
        params.put("grant_type",grantType);
        //发送请求
        String sr = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        log.info("*** json --> {}*** ", json.toJSONString());
        resultInfo.setData(json);
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        return resultInfo;
    }

    //2、对encryptedData加密数据进行AES解密
    //下面开始获取微信信息

    @GetMapping(value = "WxGetUserInfo")
    //需要三个参数 我这里用的对象传的 encryptedData，session_key，iv具体看方法里有解释
    public ResultInfo WxGetUserInfo(@RequestBody WxGetUserInfoParam param){
        try {		//调用工具给上面的三个参数，这些参数前端都可以给
            String result = AesUtil.decrypt(param.getEncryptedData(), param.getSessionKey(),param.getIv(), "UTF-8");
            if (null != result && result.length() > 0) {

                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map<String,Object> userInfo = new HashMap<>();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.newSuccessResultInfo();
    }
}
