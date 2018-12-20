package com.boot1.chris.mapper;

import com.boot1.chris.entity.Girl;
import org.springframework.stereotype.Repository;

/**
 * Created by wangchaohui on 2018/1/18.
 */
@Repository
public interface GirlMapper {

    Girl getGirlById(int id);
}
