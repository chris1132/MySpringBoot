package com.boot1.chovy.service.impl;

import com.boot1.chovy.dao.StudentDao;
import com.boot1.chovy.entity.Student;
import com.boot1.chovy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/1/18.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    public Student getStudentById(int id){
       return studentDao.getStudentById(id);
    }
}
