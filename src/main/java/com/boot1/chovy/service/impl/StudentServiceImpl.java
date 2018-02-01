package com.boot1.chovy.service.impl;

import com.boot1.chovy.dao.StudentDao;
import com.boot1.chovy.entity.Student;
import com.boot1.chovy.service.ListTurnInterface;
import com.boot1.chovy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void insert(Student student){
        studentDao.insert(student);
    }

    public List<Student> getList(){
        return studentDao.getList();
    }

    public List<String> getResList(){
        this.getList();
        ListTurnInterface<List<Student>,List<String>> turnList = (from)->{
            List<String> tolist = new ArrayList<String>();
            from.stream().filter(f->f.getAge()<26).forEach(f->tolist.add(f.getName()));
            return tolist;
        };
        List<String> toList = turnList.concert(this.getList());
        Collections.sort(toList,(String a,String b)->a.compareTo(b));
        return toList;
    }
}
