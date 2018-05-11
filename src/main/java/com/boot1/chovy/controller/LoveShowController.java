package com.boot1.chovy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangchaohui on 2018/4/20.
 */
@RestController
public class LoveShowController {

    @RequestMapping(value = "/show1.htm",method = RequestMethod.GET)
    public ModelAndView show(ModelAndView md ){
        md.setViewName("love1/lovetree");
        return md;
    }


    @RequestMapping(value = "/show2.htm",method = RequestMethod.GET)
    public ModelAndView show2(ModelAndView md ){
        md.setViewName("love2/lovetree2");
        return md;
    }

    @RequestMapping(value = "/show3",method = RequestMethod.GET)
    public ModelAndView show3(ModelAndView md ){
        md.setViewName("love2/index.html");
        return md;
    }
}
