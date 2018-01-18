package com.chovy.chris.controller;

import com.chovy.chris.dao.GirlRep;
import com.chovy.chris.entity.Girl;
import com.chovy.chris.entity.GirlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRep girlRep;

    @Autowired
    private GirlBean girlBean;

    @ResponseBody
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String test(){
        return "ss"+girlBean.getName();
    }

    @RequestMapping(value = "/girl",method= RequestMethod.GET)
    public List<Girl> getGirlList(){
        return girlRep.findAll();
    }

    @RequestMapping(value = "/girls",method = RequestMethod.POST)
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRep.save(girl);
    }
}
