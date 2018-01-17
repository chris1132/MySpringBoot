package com.chovy.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by wangchaohui on 2018/1/17.
 */
public class MyWatch implements Watcher {
    public void process(WatchedEvent event){
        System.out.println(event.getPath());
        System.out.println(event.getType());
        System.out.println(event.getState());
    }
}
