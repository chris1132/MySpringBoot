package com.boot1.chovy.server_open_impl;


import com.boot1.chovy.entity.Student;
import com.boot1.chovy.service.StudentService;
import com.boot1.rpc.netty_zookeeper_spring.server.RpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangchaohui on 2018/3/16.
 */
@RpcService(HelloServiceImpl.class)
public class HelloServiceImpl implements HelloService {

    @Autowired
    private StudentService studentService;

    public HelloServiceImpl(){}

    @Override
    public String Hello(String name){
        return "Hello:________"+name;
    }

    @Override
    public String Hello(Student student){
        StringBuffer sbf = new StringBuffer();
        return sbf.append("Hello:______").append(student.toString()).toString();
    }

    @Override
    public String Hello(int id){
        return studentService.getStudentById(id).toString();
    }
}
