package com.boot1.kafka.kafkaclient_version;

import com.boot1.kafka.kafkaclient_version.properties.KafKaConsumerPropertiesBean;
import com.boot1.kafka.kafkaclient_version.properties.KafKaProducerPropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * Created by wangchaohui on 2018/1/25.
 */

public class KafkaProperties {

    @Autowired
    private KafKaProducerPropertiesBean producerPro;

    @Autowired
    private KafKaConsumerPropertiesBean consumerPro;

    private Properties producerProps;

    private Properties consumerPros;

    public Properties getproducerProperties() {
        if (null == producerProps) {
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

    public Properties getconsumerProperties() {
        if (null == consumerPros) {
            consumerPros = new Properties();
            consumerPros.put("bootstrap.servers", consumerPro.getBootstrapServer());
            consumerPros.put("group.id", consumerPro.getGroupId());
            consumerPros.put("enable.auto.commit", consumerPro.getAutoCommit());
            consumerPros.put("auto.commit.interval.ms", consumerPro.getIntervalMs());
            consumerPros.put("session.timeout.ms", consumerPro.getTimeoutMs());
            consumerPros.put("key.serializer", consumerPro.getKeySerializer());
            consumerPros.put("value.serializer", consumerPro.getValueSerializer());
        }
        return consumerPros;
    }
}
