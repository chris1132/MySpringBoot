package com.chovy.chris.mapper;

import com.chovy.chovy.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface StudentMapper {

    @Select("select * from student where id = #{id}")
    @Results(value = {})
    public Student getStudent(@Param("id") int id);
}
