package com.boot1.rpc.netty_zookeeper_spring.testmain;


import com.boot1.chovy.server_open_impl.HelloService;
import com.boot1.chovy.server_open_impl.HelloServiceImpl;
import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceRegistry;
import com.boot1.rpc.netty_zookeeper_spring.server.RpcServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangchaohui on 2018/3/15.
 */
public class RpcServerMain {
    private static Logger logger = LoggerFactory.getLogger(RpcServerMain .class);

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1:8088";
        ServiceRegistry serviceRegistry = new ServiceRegistry("127.0.0.1:2181");
        RpcServer rpcServer = new RpcServer(serverAddress, serviceRegistry);

        HelloService helloService = new HelloServiceImpl();
        rpcServer.addService("HelloService", helloService);

        try {
            rpcServer.start();
        } catch (Exception ex) {
            logger.error("Exception: {}", ex);
        }
    }
}
