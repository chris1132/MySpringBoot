package com.boot1.kafka.kafkaclient_version;

import com.boot1.kafka.kafkaclient_version.enums.TopicEnum;
import com.boot1.kafka.kafkaclient_version.properties.KafKaConsumerPropertiesBean;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by wangchaohui on 2018/1/25.
 */
@Component
public class MyKafkaConsumer {

    @Autowired
    private KafKaConsumerPropertiesBean consumerPro;

    private Properties consumerPros;

    public Properties getconsumerProperties() {
        if (null == consumerPros) {
            consumerPros = new Properties();
            consumerPros.put("bootstrap.servers", consumerPro.getBootstrapServer());
            consumerPros.put("group.id", consumerPro.getGroupId());
            consumerPros.put("enable.auto.commit", consumerPro.getAutoCommit());
            consumerPros.put("auto.commit.interval.ms", consumerPro.getIntervalMs());
            consumerPros.put("session.timeout.ms", consumerPro.getTimeoutMs());
            consumerPros.put("key.deserializer", consumerPro.getKeySerializer());
            consumerPros.put("value.deserializer", consumerPro.getValueSerializer());
        }
        return consumerPros;
    }

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    public void get() {
        Properties pro = this.getconsumerProperties();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(pro);
        consumer.subscribe(Arrays.asList(TopicEnum.TOPIC_ONE.getName()));
        ConsumerRecords<String, String> records = consumer.poll(100);
        System.out.println("START----------------GET");
        for (ConsumerRecord<String, String> record : records) {
            System.out.printf("offset = %d, key = %s, value = %s \n",
                    record.offset(), record.key(), record.value());
        }
    }

}
