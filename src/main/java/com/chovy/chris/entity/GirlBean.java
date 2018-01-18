package com.chovy.chris.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wangchaohui on 2017/9/7.
 */

@Component
@PropertySource(value="classpath:person.properties")
@ConfigurationProperties(prefix = "girlBean")
public class GirlBean {

    private String name;

    private int age;

    public GirlBean(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "GirlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
