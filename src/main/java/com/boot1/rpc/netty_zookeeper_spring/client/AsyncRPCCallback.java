package com.boot1.rpc.netty_zookeeper_spring.client;

/**
 * Created by wangchaohui on 2018/3/16.
 */
public interface AsyncRPCCallback {

    void success(Object result);

    void fail(Exception e);

}
