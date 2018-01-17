package com.chovy.boot1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@Entity
public class GirlMapperBean {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    private Integer age;

    public GirlMapperBean() {
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
