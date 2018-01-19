package com.boot1.chris.controller;

import com.boot1.chris.entity.Girl;
import com.boot1.chris.mapper.GirlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlMapper girlMapper;

    @RequestMapping(value = "/girl",method= RequestMethod.GET)
    public Girl getGirl(){
        Girl girl = girlMapper.getGirl(1);
        return girl;
    }
}
