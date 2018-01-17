package com.chovy.boot2;

import com.chovy.boot1.GirlMapperBean;
import com.chovy.boot1.GirlBean;
import com.chovy.boot1.GirlRep;
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
    public List<GirlMapperBean> getGirlList(){
        return girlRep.findAll();
    }

    @RequestMapping(value = "/girls",method = RequestMethod.POST)
    public GirlMapperBean addGirl(@RequestParam("cupSize") String cupSize,
                                  @RequestParam("age") Integer age){
        GirlMapperBean girlMapperBean = new GirlMapperBean();
        girlMapperBean.setAge(age);
        girlMapperBean.setCupSize(cupSize);
        return girlRep.save(girlMapperBean);
    }
}
