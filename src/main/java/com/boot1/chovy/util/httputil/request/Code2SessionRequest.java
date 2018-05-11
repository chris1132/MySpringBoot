package com.boot1.chovy.util.httputil.request;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class Code2SessionRequest {


    /**
     *小程序唯一标识
     * */
    private String appid;

    /**
     *小程序的 app secret
     * */
    private String secret;

    /**
     *	登录时获取的 code
     * */
    private String js_code;

    /**
     *默认填写为 authorization_code
     * */
    private String grant_type;


    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
