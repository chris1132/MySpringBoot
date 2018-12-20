package com.boot1.kafka.kafkaclient_version.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2018/1/25.
 */
@Component
//@Configuration
//@EnableAutoConfiguration
@PropertySource(value = "classpath:kafka.properties")
//@ConfigurationProperties(prefix = "producer")
public class KafKaProducerPropertiesBean {

    @Value("${producer.bootstrap.servers}")
    private String bootstrapServer;

    @Value("${producer.acks}")
    private String acks;

    @Value("${producer.retries}")
    private String retries;

    @Value("${producer.batch.size}")
    private String batchSize;

    @Value("${producer.linger.ms}")
    private String lingerMs;

    @Value("${producer.buffer.memory}")
    private String bufferMemory;

    @Value("${producer.key.serializer}")
    private String keySerializer;

    @Value("${producer.value.serializer}")
    private String valueSerializer;


    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public void setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public String getRetries() {
        return retries;
    }

    public void setRetries(String retries) {
        this.retries = retries;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getLingerMs() {
        return lingerMs;
    }

    public void setLingerMs(String lingerMs) {
        this.lingerMs = lingerMs;
    }

    public String getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(String bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }


    @Override
    public String toString() {
        return "KafKaProducerPropertiesBean{" +
                "bootstrapServer='" + bootstrapServer + '\'' +
                ", acks='" + acks + '\'' +
                ", retries=" + retries +
                ", batchSize=" + batchSize +
                ", lingerMs=" + lingerMs +
                ", bufferMemory=" + bufferMemory +
                ", keySerializer='" + keySerializer + '\'' +
                ", valueSerializer='" + valueSerializer + '\'' +
                '}';
    }
}
