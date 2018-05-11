package com.boot1.chovy.service.Wechat.impl;

import com.boot1.chovy.service.Wechat.WechatService;
import com.boot1.chovy.util.CheckedExceptionUtil;
import com.boot1.chovy.util.ContextUtil;
import com.boot1.chovy.util.JSONUtil;
import com.boot1.chovy.util.MD5;
import com.boot1.chovy.util.httputil.HttpUtil;
import com.boot1.chovy.util.httputil.response.Code2SessionResponse;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/5/11.
 */
@Service
public class WechatServiceImpl implements WechatService{

    public Code2SessionResponse code2Session(String code){
        String url = ContextUtil.code_2_sessionkey_url.replace("APPID",ContextUtil.app_id).replace("SECRET",ContextUtil.secret).replace("JSCODE",code);
        Code2SessionResponse jsonRes =(Code2SessionResponse)JSONUtil.strToBean(HttpUtil.httpRequest(url,"POST",null),Code2SessionResponse.class);
        return jsonRes;
    }

    public String getThirdSession(String value) throws CheckedExceptionUtil{
        return MD5.getMD5String(value);
    }
}
