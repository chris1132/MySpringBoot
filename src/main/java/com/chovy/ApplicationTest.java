package com.chovy;
import org.springframework.boot.*;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.*;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wangchaohui on 2017/9/6.
 */
@SpringBootApplication
@EnableScheduling
public class ApplicationTest implements HealthIndicator {

    @Override
    public Health health(){
        return Health.up().withDetail("hello","wang").build();
    }

    public static void main(String[] args){
        SpringApplication.run(ApplicationTest.class,args);
    }
}
