package com.boot2.chris.controller;

import com.boot2.chris.entity.Girl;
import com.boot2.chris.persistent.GirlPersistent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2018/1/19.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlPersistent girlPersistent;


    @RequestMapping(value = "/girl2")
    public Girl getGirl(@RequestParam(value = "id",required = false,defaultValue = "1") int id){
        return girlPersistent.getGirlById(id);
    }
}
