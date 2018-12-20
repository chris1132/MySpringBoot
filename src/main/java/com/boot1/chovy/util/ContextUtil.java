package com.boot1.chovy.util;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class ContextUtil {


    public static String ADMIN_SESSION_KEY_USER_IS_LOGIN = "admin_session_user_is_login";
    public static String ADMIN_SESSION_KEY_USER_INFO = "admin_session_user_info";


    public final static String app_id = "wxdc81be3735e25814";

    public final static String secret = "c8de20295533dcda206fef894cb2eaac";

    /**
     * 开发者服务器使用登录凭证 code 获取 session_key 和 openid
     */
    public final static String code_2_sessionkey_url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
}
