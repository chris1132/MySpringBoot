package com.boot1.chovy.event4study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Created by wangchaohui on 2018/6/6.
 */
@Service
public class UserService implements ApplicationEventPublisherAware {
    public final static Logger log = LoggerFactory.getLogger(UserService.class);
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public void register(String name) {
        log.info("ÓÃ»§£º" + name + " ÒÑ×¢²á£¡");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
    }
}
