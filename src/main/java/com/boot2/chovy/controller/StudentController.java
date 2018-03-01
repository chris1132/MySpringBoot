package com.boot2.chovy.controller;

import com.boot2.chovy.entity.Student;
import com.boot2.chovy.persistent.StudentPersistent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value="/getlist2",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getList(){
        return studentPersistent.getList();
    }

    @RequestMapping(value = "/insert2",method = RequestMethod.GET)
    public String insert(@RequestParam(value = "name",defaultValue = "chris11", required = false) String name,
                         @RequestParam(value = "age",defaultValue = "18", required = false) int age,
                         @RequestParam(value = "grade",defaultValue = "98", required = false) int grade){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        studentPersistent.insert(student);
        return "success";
    }
}
