package com.chovy.boot1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wangchaohui on 2017/9/7.
 */

@Component
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
