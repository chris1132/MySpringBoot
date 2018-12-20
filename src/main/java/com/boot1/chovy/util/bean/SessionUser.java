package com.boot1.chovy.util.bean;

import java.io.Serializable;

/**
 * Created by wangchaohui on 2018/5/10.
 */
public class SessionUser implements Serializable {

    private static final long serialVersionUID = -5272401653937165074L;
    /**
     * 本服务器sessionid
     */
    private String sessionId;

    /**
     * w微信sessionkey-opid组合
     */
    private String wxSession;

    private Integer uid;

    private String userName;

    private String avatar;


    public SessionUser() {
    }

    public SessionUser(String wxSession, Integer uid, String userName, String avatar) {
        this.wxSession = wxSession;
        this.uid = uid;
        this.userName = userName;
        this.avatar = avatar;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getWxSession() {
        return wxSession;
    }

    public void setWxSession(String wxSession) {
        this.wxSession = wxSession;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
