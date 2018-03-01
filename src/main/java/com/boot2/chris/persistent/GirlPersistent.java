package com.boot2.chris.persistent;

import com.boot2.chris.entity.Girl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wangchaohui on 2018/1/19.
 */
public interface GirlPersistent {


    @Select("select * from girl where id=#{id}")
    @Results({
            @Result(column = "cup_size",property = "cupSize"),
            @Result(column = "age",property = "age")
    })
    Girl getGirlById(@Param("id")int id);
}
