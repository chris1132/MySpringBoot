package com.boot1.chovy.dao;

import com.boot1.chovy.entity.Student;

import java.util.List;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface StudentDao {

    public Student getStudentById(int id);

    public void insert(Student student);

    List<Student> getList();
}
