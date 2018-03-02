package com.boot1.kafka;

import com.boot1.kafka.kafkaclient_version.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2018/1/25.
 */
@RestController
public class kafkaTestController {

    @Autowired
    private MyKafkaProducer myKafkaProducer;

    @RequestMapping("/kafka")
    public String send(){
        myKafkaProducer.send("hello_");
        return "success";
    }
}
