package com.boot1.chovy.mapper;

import com.boot1.chovy.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface StudentMapper {

    @Select("select * from student where id = #{id}")
    @Results(value = {})
    Student getStudent(@Param("id") int id);
}
