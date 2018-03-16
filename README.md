# MySpringBootTest
用spring boot搭建的项目，用于自己学习，里面目前包含：

---2018.01.19---
  尝试了两种mybatis多数据源配置（1）com.boot1路径下 以mybatis的xml形式  (2)com.boot2.路径下，主要以注解形式

---2018.01.25---
    搭建zookeeper、kafka

 ---2018.02.01---
在 com.boot1.chovy在这个路径的文件里，为了复习java8，用了stream lambda FunctionalInterface这些

---2018.03.01---
增加定时任务 实现kafka消费者定时取数据

---2018.03.02---
增加redis，在boot.chovy 在service层进行缓存的读取存储；

---2018.03.12---
实现netty的一个简单demo，tcp协议，分别实现client和server，client发送一个消息，server接收到后给反馈。
路径：com.boot1.rpc.simple_netty

---2018.03.16---
用Zookeeper、Netty和Spring写了一个轻量级的分布式RPC框架
参考http://www.cnblogs.com/luxiaoxun/p/5272384.html大神分享的
路径：com.boot1.rpc.netty_zookeeper_spring 和 com.boot1.chovy.controller.RpcController
完成:   1.服务发布与订阅：服务端使用Zookeeper注册服务地址，客户端从Zookeeper获取可用的服务地址。
        2.使用Netty作为通信框架
        3.使用Protostuff序列化和反序列化消息
        4.客户端使用代理模式透明化服务调用
项目启动时，com.boot1.rpc.netty_zookeeper_spring.autorun里的方法会自动启动server端,然后用rpccontroller做client端传从需要请求的消息,server收到后返回数据
在这里对原贴做了改正,同时重新封装了一些方法。client传到server的request里封装的classname不应该用xx.class的方式去取,因为正常来说,client的包里里不应该创建server里业务实现相关的对象,所以client只传一个名字

今天时间不够，后续待改进一个问题。server里目前是直接返回消息，下次改进，根据client传过来的类和方法名，去处理数据

-------未完待续---------
