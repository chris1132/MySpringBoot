package com.boot1.kafka.kafkaclientVersion;

import com.boot1.kafka.kafkaclientVersion.properties.KafKaProducerPropertiesBean;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.PartitionInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.boot1.kafka.kafkaclientVersion.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2018/1/24.
 */

@Component
public class MyKafkaProducer{

    @Autowired
    private KafKaProducerPropertiesBean producerPro;

    private Properties producerProps;

    public Properties getproducerProperties(){
        if(null == producerProps){
            producerProps = new Properties();
            producerProps.put("bootstrap.servers", producerPro.getBootstrapServer());
            producerProps.put("acks", producerPro.getAcks());
            producerProps.put("retries", producerPro.getRetries());
            producerProps.put("batch.size", producerPro.getBatchSize());
            producerProps.put("linger.ms", producerPro.getLingerMs());
            producerProps.put("buffer.memory", producerPro.getBufferMemory());
            producerProps.put("key.serializer", producerPro.getKeySerializer());
            producerProps.put("value.serializer", producerPro.getValueSerializer());
        }
        return producerProps;
    }

    public String send(String value){
        try{
            Properties props = this.getproducerProperties();
            Producer<String,String> producer = new KafkaProducer<String, String>(props);
            for(int i=0;i<10;i++){
                ProducerRecord<String,String> msg = new ProducerRecord<String, String>(TopicEnum.TOPIC_ONE.getName(),String.valueOf(i),value+"__"+i);
                producer.send(msg);
//                producer.send(msg, new Callback() {
//                    @Override
//                    public void onCompletion(RecordMetadata metadata, Exception e) {
//                        if(e != null) {
//                            e.printStackTrace();
//                        } else {
//                            System.out.println("The offset of the record we just sent is: " + metadata.offset());
//                        }
//                    }
//                });
            }
            List<PartitionInfo> partitions = new ArrayList<PartitionInfo>() ;
            partitions = producer.partitionsFor(TopicEnum.TOPIC_ONE.getName());
            System.out.println("START----------------partitions");
            for(PartitionInfo p:partitions)
            {
                System.out.println(p);
            }
            System.out.println("END----------------partitions");
            producer.close(100, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "succ";
        }
    }
}
