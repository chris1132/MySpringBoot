package com.boot1.chovy.service.impl;

import com.boot1.chovy.entity.Student;
import com.boot1.chovy.mapper.StudentMapper;
import com.boot1.chovy.service.ListTurnInterface;
import com.boot1.chovy.service.StudentService;
import com.boot1.redis.RedisUtils;
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
    private StudentMapper studentMapper;

    @Autowired
    private RedisUtils redisUtils;

    public Student getStudentById(int id){
        String cacheKey = "getStudentById_"+id;
        Student s = (Student)redisUtils.get(cacheKey);
        if(null==s){
            s = studentMapper.getStudentById(id);
            redisUtils.set(cacheKey,s,20L);
        }
       return s;
    }

    public void insert(Student student){
        studentMapper.insert(student);
    }

    public List<Student> getList(){
        return studentMapper.getList();
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
