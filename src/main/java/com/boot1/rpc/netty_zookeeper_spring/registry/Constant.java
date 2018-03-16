package com.boot1.rpc.netty_zookeeper_spring.registry;

/**
 * Created by wangchaohui on 2018/3/16.
 */
public interface Constant {

    int ZK_SESSION_TIMEOUT = 5000;

    String ZK_REGISTRY_PATH = "/registry";
    String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
}
