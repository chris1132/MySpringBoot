package com.chovy.chovy.dao.impl;

import com.chovy.chovy.dao.StudentDao;
import com.chovy.chovy.entity.Student;
import com.chovy.chovy.mapper.StudentMapper;
import com.chovy.common.datasource.DatabaseContextHolder;
import com.chovy.common.datasource.DatabaseType;
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
        DatabaseContextHolder.setDatabaseType(DatabaseType.chovy);
        return studentMapper.getStudent(id);
    }
}
