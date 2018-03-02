package com.boot1.kafka.kafkaclient_version.Schedule;

import com.boot1.kafka.kafkaclient_version.MyKafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2018/2/28.
 */

@Component
public class ConsumerGetSchedule{

    @Autowired
    private MyKafkaConsumer myKafkaConsumer;

    @Scheduled(cron = "5 * * * * ?")
    public void cron(){
        System.out.println("START----------------Schedule");
        myKafkaConsumer.get();
    }
}
