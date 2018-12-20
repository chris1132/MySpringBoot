package com.boot1.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by wangchaohui on 2018/1/17.
 */
public class zookeeper_cluster {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183", 30000, new MyWatch());
        String node = "/node2";
        Stat stat = zk.exists(node, false);
        if (null == stat) {
            String createR = zk.create(node, "boot1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.print(createR);
        }
        byte b[] = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }

}