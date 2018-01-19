package com.boot1.chovy.controller;

import com.boot1.chovy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String test(){
        return studentService.getStudentById(1).getName();
    }

}
