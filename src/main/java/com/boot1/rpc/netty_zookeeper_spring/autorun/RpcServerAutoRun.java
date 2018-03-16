package com.boot1.rpc.netty_zookeeper_spring.autorun;

import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceRegistry;
import com.boot1.rpc.netty_zookeeper_spring.server.RpcServer;
import com.boot1.rpc.netty_zookeeper_spring.server.RpcService;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchaohui on 2018/3/16.
 */
@Component
public class RpcServerAutoRun implements ApplicationRunner,ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(RpcServerAutoRun .class);

    private Map<String, Object> handlerMap=new HashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception{
        String serverAddress = "127.0.0.1:18866";
        ServiceRegistry serviceRegistry = new ServiceRegistry("127.0.0.1:2181");
        RpcServer rpcServer = new RpcServer(serverAddress, serviceRegistry);

//
        rpcServer.handlerMap=handlerMap;

//        HelloService helloService = new HelloServiceImpl();
//        rpcServer.addService("HelloService", helloService);

        try {
            rpcServer.start();
        } catch (Exception ex) {
            logger.error("Exception: {}", ex);
        }
    }

    /**
     * 服务在启动的时候扫描得到所有的服务接口及其实现：
     * */
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String, Object> serviceBeanMap = ctx.getBeansWithAnnotation(RpcService.class);
        if (MapUtils.isNotEmpty(serviceBeanMap)) {
            for (Object serviceBean : serviceBeanMap.values()) {
                String interfaceName = serviceBean.getClass().getAnnotation(RpcService.class).value().getName();
                logger.info("Loading service: {}", interfaceName);
                handlerMap.put(interfaceName, serviceBean);
            }
        }
    }
}
