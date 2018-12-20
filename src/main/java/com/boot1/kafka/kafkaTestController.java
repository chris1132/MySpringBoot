package com.boot1.kafka;

import com.boot1.kafka.kafkaclient_version.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * Created by wangchaohui on 2018/1/25.
 */
@RestController
public class kafkaTestController {

    @Autowired
    private MyKafkaProducer myKafkaProducer;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @RequestMapping("/kafka")
    public String send() {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() {
                return 1;
            }
        };
        Future<Integer> result = executorService.submit(callable);
        try {
            System.out.println("子线程执行结果:" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        myKafkaProducer.send("hello_");
        return "success";
    }
}
