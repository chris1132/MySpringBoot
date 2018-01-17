package com.chovy.boot1;

import org.springframework.web.bind.annotation.*;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
@RequestMapping(value = "/spring3")
public class GirlController3 {

    @ResponseBody
    @RequestMapping(value="/hi3",method = RequestMethod.GET)
    public String test3(){
        GirlBean girl=new GirlBean();
        return "ss"+girl.getName();
    }

}
