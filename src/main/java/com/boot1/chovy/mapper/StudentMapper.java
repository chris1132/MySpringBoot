package com.boot1.chovy.mapper;

import com.boot1.chovy.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface StudentMapper {

    Student getStudentById(int id);

    int insert(Student student);

    List<Student> getList();

}
