package com.guangzhou.college.cms.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.guangzhou.college.common.ResultInfo;
import com.guangzhou.college.common.utils.AesUtil;
import com.guangzhou.college.common.utils.HttpUtil;
import com.guangzhou.college.entity.wechat.WxGetUserInfoParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/wx")
public class WeChatController {

    //@ApiOperation("获取微信小程序的openid")
    //@ResponseBody
    @GetMapping(value = "/getOpenid")
    public ResultInfo getOpenid(String code) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            System.out.println("map1:" + map);
            return ResultInfo.newFailResultInfo("code不能为空");
        }
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "************";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "************";
        //授权（必填）  一般都是这个 可不用改
        String grant_type = "authorization_code";
        //1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        Map<String,Object> params = new HashMap<>();
        params.put("appid",wxspAppid);
        params.put("secret",wxspSecret);
        params.put("js_code",code);
        params.put("grant_type",grant_type);
        //发送请求
        String sr = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        System.out.println("openid:" + openid);

        return new ResultInfo();
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
