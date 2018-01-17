package com.chovy.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2017/9/7.
 */

@ConfigurationProperties(prefix="girl")
@Component
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
