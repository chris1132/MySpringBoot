package com.boot1.chovy.event4study;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/6/6.
 */


public class UserRegisterEvent extends ApplicationEvent {
    public UserRegisterEvent(String name) {
        super(name);
    }
}
