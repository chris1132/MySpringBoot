package com.boot1.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by wangchaohui on 2018/1/17.
 */
public class zookeeper_simple {

    public static void main(String[] args) throws IOException,InterruptedException,KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",30000,new MyWatch());
        String node = "/node2";
        Stat stat = zk.exists(node,false);
        if(null == stat){
            String createR = zk.create(node,"boot1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            System.out.print(createR);
        }
        byte b[] = zk.getData(node,false,stat);
        System.out.println(new String(b));
        zk.close();
    }

}