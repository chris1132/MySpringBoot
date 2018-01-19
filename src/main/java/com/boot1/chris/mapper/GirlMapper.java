package com.boot1.chris.mapper;

import com.boot1.chovy.entity.Student;
import com.boot1.chris.entity.Girl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public interface GirlMapper {

    @Select("select * from girl where id = #{id}")
    @Results({
            @Result(property = "cupSize",column = "cup_size"),
            @Result(property = "age",column = "age")
    })
    Girl getGirlById(@Param("id") int id);
}
