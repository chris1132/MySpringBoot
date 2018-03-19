package com.boot1.chovy.controller;

import com.boot1.chovy.client_open_impl.RpcImplement4Client;
import com.boot1.chovy.entity.Student;
import com.boot1.rpc.netty_zookeeper_spring.client.RPCFuture;
import com.boot1.rpc.netty_zookeeper_spring.client.RpcClient;
import com.boot1.rpc.netty_zookeeper_spring.client.proxy.IAsyncObjectProxy;
import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class RpcController {

    @Autowired
    private RpcImplement4Client rpcClient;

    @ResponseBody
    @RequestMapping(value="/rpc",method = RequestMethod.GET)
    public String rpc(@RequestParam(value = "id",defaultValue = "1",required = false)int id)throws Exception{
        Object res = rpcClient.client4Async("HelloServiceImpl","Hello",id);
        return res.toString();
    }

}
