package com.boot1.rpc.netty_zookeeper_spring.client.proxy;


import com.boot1.rpc.netty_zookeeper_spring.client.RPCFuture;

/**
 * Created by wangchaohui on 2018/3/16.
 */
public interface IAsyncObjectProxy {
    public RPCFuture call(String funcName, Object... args);
    public RPCFuture call(String className,String funcName, Object... args);
}