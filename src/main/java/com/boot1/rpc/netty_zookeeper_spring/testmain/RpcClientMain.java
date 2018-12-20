package com.boot1.rpc.netty_zookeeper_spring.testmain;


import com.boot1.chovy.entity.Student;
import com.boot1.rpc.netty_zookeeper_spring.client.RPCFuture;
import com.boot1.rpc.netty_zookeeper_spring.client.RpcClient;
import com.boot1.rpc.netty_zookeeper_spring.client.proxy.IAsyncObjectProxy;
import com.boot1.rpc.netty_zookeeper_spring.registry.ServiceDiscovery;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangchaohui on 2018/3/16.
 */
public class RpcClientMain {

    public static void main(String[] args) {

        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
        final RpcClient rpcClient = new RpcClient(serviceDiscovery);
        // Sync call
//    BaseOpenService helloService = rpcClient.create(BaseOpenService.class);
//    String result = helloService.Hello("��Һã��Ҹ���");

        // Async call
//    IAsyncObjectProxy client = rpcClient.createAsync(BaseOpenService.class);
        /**
         * by chovy
         * ���������˸�����client����server��request����װ��classname��Ӧ����xx.class�ķ�ʽȥȡ
         * ��Ϊ������˵,client�İ����ﲻӦ�ô���server��ҵ��ʵ����صĶ���,����clientֻ��һ������
         * */
        IAsyncObjectProxy client = rpcClient.createAsync();
        RPCFuture helloFuture = client.call("HelloService", "Hello", new Student(1, "chris", 11, 18));
        try {
            String result2 = (String) helloFuture.get(3000, TimeUnit.MILLISECONDS);
            System.out.println("2______________________:" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
