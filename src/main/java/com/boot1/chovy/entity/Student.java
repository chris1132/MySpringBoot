package com.boot1.chovy.entity;

import java.io.Serializable;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -4635249524162312121L;
    private Integer id;
    private String name;
    private Integer age;
    private Integer grade;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
