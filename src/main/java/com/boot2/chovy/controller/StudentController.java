package com.boot2.chovy.controller;

import com.boot2.chovy.entity.Student;
import com.boot2.chovy.persistent.StudentPersistent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2018/1/19.
 */

@RestController
public class StudentController {

    @Autowired
    private StudentPersistent studentPersistent;

    @RequestMapping(value = "/student2",method = RequestMethod.GET)
    public Student get(@RequestParam(value = "id" , required = false , defaultValue = "1") int id){
        return studentPersistent.getStudentById(id);
    }

}
