package com.boot1.chovy.util.httputil.response;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class Code2SessionResponse {

    /**
     * �û�Ψһ��ʶ
     */
    private String openid;


    /**
     * ���û����ݽ��м���ǩ������Կ
     * �Ự��Կ
     */
    private String session_key;


    /**
     * �û��ڿ���ƽ̨��Ψһ��ʶ�������ֶ�������һ������������²ŷ���
     */
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
