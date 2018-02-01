package com.boot1.chovy.service;

import com.boot1.chovy.entity.Student;

import java.util.List;

/**
 * Created by wangchaohui on 2018/1/18.
 */

public interface StudentService {

    Student getStudentById(int id);

    void insert(Student student);

    List<Student> getList();

    public List<String> getResList();
}
