package com.boot2.chovy.persistent;


import com.boot2.chovy.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by wangchaohui on 2018/1/19.
 */
public interface StudentPersistent {

     @Select("select * from student where id=#{id}")
     @Results(value = {})
     Student getStudentById(@Param("id")int id);


     @Insert("insert into student(name,age,grade) values( #{name},#{age},#{grade})")
     void insert(Student student);

     @Select("select * from student")
     @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "name",column = "name"),
             @Result(property = "age",column = "age"),
             @Result(property = "grade",column = "grade")
     })
     List<Student> getList();
}
