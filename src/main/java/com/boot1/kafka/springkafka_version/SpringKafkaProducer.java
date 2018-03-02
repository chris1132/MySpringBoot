//package com.boot1.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by wangchaohui on 2018/1/23.
// */
//
//@RestController
//@EnableAutoConfiguration
//public class SpringKafkaProducer {
//
//    public Logger logger= LoggerFactory.getLogger(SpringKafkaProducer.class);
//
//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;
//
//
//    @RequestMapping(value = "/kafka")
//    @ResponseBody
//    public String send(){
//        kafkaTemplate.send("t1","test1","hello");
//        return "success";
//    }
//
//    @KafkaListener(id = "t1",topics = "t1")
//    public void listen(ConsumerRecord<?,?> cr) throws Exception{
//        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
//    }
//}
