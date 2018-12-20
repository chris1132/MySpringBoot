package com.boot1.chovy.event4study;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/6/6.
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("邮件服务接到通知，给 " + userRegisterEvent.getSource() + " 发送邮件...");
    }
}
