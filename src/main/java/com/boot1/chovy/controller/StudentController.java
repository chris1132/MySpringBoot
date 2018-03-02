package com.boot1.chovy.controller;

import com.boot1.chovy.entity.Student;
import com.boot1.chovy.service.StudentService;
import com.boot1.config.redis_config.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @RequestMapping(value="/getlist",method = RequestMethod.GET)
    public List<String> getlist(){
        return studentService.getResList();
    }

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(@RequestParam(value = "name",defaultValue = "chris11", required = false) String name,
                         @RequestParam(value = "age",defaultValue = "18", required = false) int age,
                         @RequestParam(value = "grade",defaultValue = "98", required = false) int grade){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        studentService.insert(student);
        return "success";
    }

}
