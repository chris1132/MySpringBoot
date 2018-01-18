package com.chovy.chovy.controller;

import com.chovy.chovy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class GirlController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String test(){
        return "ss"+studentService.getStudent(1);
    }

}
