package com.boot1.chovy.dao.impl;

import com.boot1.chovy.dao.StudentDao;
import com.boot1.chovy.entity.Student;
import com.boot1.chovy.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangchaohui on 2018/1/18.
 */

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private StudentMapper studentMapper;


    public Student getStudent(int id){
        return studentMapper.getStudent(id);
    }
}
