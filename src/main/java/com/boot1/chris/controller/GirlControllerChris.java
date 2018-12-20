package com.boot1.chris.controller;

import com.boot1.chris.entity.Girl;
import com.boot1.chris.mapper.GirlMapper;
import com.boot1.chris.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangchaohui on 2017/9/7.
 */
@RestController
public class GirlControllerChris {

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/girl", method = RequestMethod.GET)
    public Girl getGirl() {
        Girl girl = girlService.getGirlById(1);
        return girl;
    }
}
