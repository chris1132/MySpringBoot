package com.boot1.chovy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangchaohui on 2018/8/17.
 */

@RequestMapping(value = "/transpoert")
@RestController
public class TransportController {


    @RequestMapping(value = "/showTransport", method = RequestMethod.GET)
    public ModelAndView showTransport(ModelAndView mav) {
        mav.setViewName("transport/transport");
        return mav;
    }
}
