/*
 *    Copyright 2011-2012 19lou.com
 */
package com.boot1.chovy.util;

import java.security.MessageDigest;

/**
 * MD5加密
 * Created by wangchaohui on 2018/5/11.
 */
public class MD5 {

    public static String getMD5String(String str) throws CheckedExceptionUtil {
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bytes = messageDigest.digest();
            for (byte b : bytes) {
                if (Integer.toHexString(0xFF & b).length() == 1) {
                    buffer.append("0");
                    buffer.append(Integer.toHexString(0xFF & b));
                } else {
                    buffer.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (Exception e) {
            throw new CheckedExceptionUtil("900", "MD5 加密出现异常!");
        }
        return buffer.toString();
    }

    public static String pwdEncrypt(String pwd, String regIp) throws CheckedExceptionUtil {
        String ipMd5 = getMD5String(regIp).substring(0, 16);
        String pwdMd5 = getMD5String(pwd);
        return getMD5String(pwdMd5 + ipMd5);
    }
}
