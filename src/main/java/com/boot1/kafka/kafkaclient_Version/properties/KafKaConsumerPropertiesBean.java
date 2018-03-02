package com.boot1.kafka.kafkaclient_version.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2018/1/25.
 */
@Component
@PropertySource(value = "classpath:kafka.properties")
//@ConfigurationProperties(prefix = "consumer")
public class KafKaConsumerPropertiesBean {

    @Value("${consumer.bootstrap.servers}")
    private String bootstrapServer;

    @Value("${consumer.group.id}")
    private String groupId;

    @Value("${consumer.enable.auto.commit}")
    private String autoCommit;

    @Value("${consumer.auto.commit.interval.ms}")
    private String intervalMs;

    @Value("${consumer.session.timeout.ms}")
    private String timeoutMs;

    @Value("${consumer.key.deserializer}")
    private String keySerializer;

    @Value("${consumer.value.deserializer}")
    private String valueSerializer;

    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public void setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(String autoCommit) {
        this.autoCommit = autoCommit;
    }

    public String getIntervalMs() {
        return intervalMs;
    }

    public void setIntervalMs(String intervalMs) {
        this.intervalMs = intervalMs;
    }

    public String getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(String timeoutMs) {
        this.timeoutMs = timeoutMs;
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
        return "KafKaConsumerPropertiesBean{" +
                "bootstrapServer='" + bootstrapServer + '\'' +
                ", groupId='" + groupId + '\'' +
                ", autoCommit='" + autoCommit + '\'' +
                ", intervalMs=" + intervalMs +
                ", timeoutMs=" + timeoutMs +
                ", keySerializer='" + keySerializer + '\'' +
                ", valueSerializer='" + valueSerializer + '\'' +
                '}';
    }
}
