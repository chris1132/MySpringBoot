package com.boot1.rpc.netty_zookeeper_spring.client;

import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceDiscovery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by wangchaohui on 2018/3/20.
 */
@Component
public class ZookeeperStateSchedule {

    @Scheduled(cron = "15 * * * * ?")
    public void cron(){
        System.out.println("ZookeeperStateSchedule Schedule----------------Start");
//        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
    }
}
