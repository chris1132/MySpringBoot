package com.boot2.chovy.persistent;


import com.boot2.chovy.entity.Student;

/**
 * Created by wangchaohui on 2018/1/19.
 */
public interface StudentPersistent {

     Student getStudentById(int id);
}
