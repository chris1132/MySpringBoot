package com.boot1.chovy.util;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class CheckedExceptionUtil extends Exception{

    private String code;

    private String message;

    public CheckedExceptionUtil(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
