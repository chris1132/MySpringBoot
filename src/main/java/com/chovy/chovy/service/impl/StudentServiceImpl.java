package com.chovy.chovy.service.impl;

import com.chovy.chovy.dao.StudentDao;
import com.chovy.chovy.entity.Student;
import com.chovy.chovy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/1/18.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    public Student getStudent(int id){
       return studentDao.getStudent(id);
    }
}
