package com.boot1.chovy.controller;

import com.boot1.chovy.entity.Student;
import com.boot1.rpc.netty_zookeeper_spring.client.RPCFuture;
import com.boot1.rpc.netty_zookeeper_spring.client.RpcClient;
import com.boot1.rpc.netty_zookeeper_spring.client.proxy.IAsyncObjectProxy;
import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceDiscovery;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class RpcController {


    @ResponseBody
    @RequestMapping(value="/rpc",method = RequestMethod.GET)
    public String rpc(){
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
        final RpcClient rpcClient = new RpcClient(serviceDiscovery);
        // Sync call
//    BaseOpenService helloService = rpcClient.create(BaseOpenService.class);
//    String result = helloService.Hello("大家好，我高兴");

        // Async call
//    IAsyncObjectProxy client = rpcClient.createAsync(BaseOpenService.class);

        String result2="11";
        IAsyncObjectProxy client = rpcClient.createAsync();
        RPCFuture helloFuture = client.call("com.boot1.chovy.server_open_impl.HelloServiceImpl","Hello", new Student(1,"chris",11,18));
        try {
            result2 = (String) helloFuture.get(3000, TimeUnit.MILLISECONDS);
            System.out.println("2______________________:"+result2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result2;
    }

}
