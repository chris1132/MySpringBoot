package com.chovy.test2;

import com.chovy.test.Girl;
import com.chovy.test.GirlBean;
import com.chovy.test.GirlRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
@RequestMapping(value = "/spring2")
public class GirlController2 {

    @Autowired
    private GirlRep girlRep;

    @ResponseBody
    @RequestMapping(value="/hi2",method = RequestMethod.GET)
    public String test(){
        GirlBean girl=new GirlBean();
        return "ss"+girl.getName();
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
