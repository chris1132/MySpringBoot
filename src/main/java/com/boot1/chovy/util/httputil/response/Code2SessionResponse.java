package com.boot1.chovy.util.httputil.response;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class Code2SessionResponse {

    /**
     *	用户唯一标识
     * */
    private String openid;


    /**
     * 对用户数据进行加密签名的密钥
     *	会话密钥
     * */
    private String session_key;


    /**
     *	用户在开放平台的唯一标识符。本字段在满足一定条件的情况下才返回
     * */
    private String unionid;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
