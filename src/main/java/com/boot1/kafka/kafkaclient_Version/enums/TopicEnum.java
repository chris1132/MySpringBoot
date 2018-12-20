package com.boot1.kafka.kafkaclient_version.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchaohui on 2018/1/25.
 */
public enum TopicEnum {

    TOPIC_ONE(1, "Mytopic");

    private int id;
    private String name;

    private TopicEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Integer, TopicEnum> integerToEnum = new HashMap<Integer, TopicEnum>();

    static {
        for (TopicEnum enum1 : values()) {
            integerToEnum.put(enum1.getId(), enum1);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
