package com.boot1.chovy.service.Wechat;

import com.boot1.chovy.util.CheckedExceptionUtil;
import com.boot1.chovy.util.httputil.response.Code2SessionResponse;
import com.google.gson.JsonObject;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public interface WechatService {

    public Code2SessionResponse code2Session(String code);

    public String getThirdSession(String value) throws CheckedExceptionUtil;

}
