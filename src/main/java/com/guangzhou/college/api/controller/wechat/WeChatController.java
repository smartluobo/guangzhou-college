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
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "/getUserInfo")
    public ResultInfo getUserInfo(@RequestBody Map<String,Object> params) throws Exception{
        ResultInfo resultInfo = new ResultInfo();

        log.info("*** params-->{}***",params.toString());

        String code = String.valueOf(params.get("code"));
        String encryptedData = String.valueOf(params.get("encryptedData"));
        String iv = String.valueOf(params.get("iv"));

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            return ResultInfo.newFailResultInfo("code不能为空");
        }
        Map<String,String> param = new HashMap<>();
        param.put("appid","wx4123b4481a5e6e66");
        param.put("secret","bf861f60fbc30bf11ad07a73b4fbcf98");
        param.put("js_code",code);
        param.put("grant_type","authorization_code");
        //发送请求
        String sr = HttpUtil.getHttp("https://api.weixin.qq.com/sns/jscode2session", param);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        log.info("*** json --> {}*** ", json.toJSONString());

        resultInfo.setData(WeChatUtils.wxDecrypt(encryptedData,String.valueOf(json.get("session_key")),iv));
        resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
        return resultInfo;
    }

    //2、对encryptedData加密数据进行AES解密
    //下面开始获取微信信息





/*    @GetMapping(value = "WxGetUserInfo")
    //需要三个参数 我这里用的对象传的 encryptedData，session_key，iv具体看方法里有解释
    public ResultInfo WxGetUserInfo(@RequestBody WxGetUserInfoParam param){
        ResultInfo resultInfo = new ResultInfo();
        try {		//调用工具给上面的三个参数，这些参数前端都可以给
            String result = AesUtil.decrypt(param.getEncryptedData(), param.getSessionKey(),param.getIv(), "UTF-8");
            if (null != result && result.length() > 0) {
                JSONObject userInfoJSON = JSONObject.parseObject(result);
                WxUserInfo wxUserInfo = JSONObject.toJavaObject(userInfoJSON,WxUserInfo.class);
                resultInfo.setData(wxUserInfo);
                resultInfo.setCode(ReturnCodeEnum.REQUEST_SUCCESS.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInfo;
    }*/
}
