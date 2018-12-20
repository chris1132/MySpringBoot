package com.boot1.chovy.open.server_open_impl;

import com.boot1.chovy.entity.Student;

/**
 * Created by wangchaohui on 2018/3/16.
 */

public interface HelloService {
    String Hello(String name);

    String Hello(Student student);

    String Hello(int id);
}
