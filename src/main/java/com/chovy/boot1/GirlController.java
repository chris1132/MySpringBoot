package com.chovy.boot1;

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
    private GirlBean girl;
    @ResponseBody
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String test(){
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
