package com.boot1.chovy.util.httputil.request;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class Code2SessionRequest {


    /**
     * С����Ψһ��ʶ
     */
    private String appid;

    /**
     * С����� app secret
     */
    private String secret;

    /**
     * ��¼ʱ��ȡ�� code
     */
    private String js_code;

    /**
     * Ĭ����дΪ authorization_code
     */
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
