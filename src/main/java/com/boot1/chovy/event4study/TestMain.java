package com.boot1.chovy.event4study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2018/6/6.
 */

@RestController
public class TestMain {

    @Autowired
    UserService userService;

    @RequestMapping("/enent2service")
    public String register() {
        userService.register("chris");
        return "succ";
    }
}
