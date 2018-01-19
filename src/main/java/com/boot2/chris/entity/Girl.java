package com.boot2.chris.entity;

import java.io.Serializable;

/**
 * Created by wangchaohui on 2017/9/7.
 */

public class Girl implements Serializable{

    private static final long serialVersionUID = -1906288575761614733L;
    private Integer id;
    private String cupSize;
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

}
