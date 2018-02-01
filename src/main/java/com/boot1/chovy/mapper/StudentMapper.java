package com.boot1.chovy.mapper;

import com.boot1.chovy.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface StudentMapper {

    @Select("select * from student where id = #{id}")
    @Results(value = {})
    Student getStudentById(@Param("id") int id);

    @Insert("insert into student(name,age,grade) values( #{name},#{age},#{grade}) ")
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
