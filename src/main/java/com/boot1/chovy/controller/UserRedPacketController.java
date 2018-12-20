package com.boot1.chovy.controller;

import com.boot1.chovy.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wangchaohui on 2018/10/9.
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService;


    @RequestMapping(value = "/showRedPacket", method = RequestMethod.GET)
    public ModelAndView showTransport(ModelAndView mav) {
        mav.setViewName("redpacket/redpacket");
        return mav;
    }

    @RequestMapping(value = "/grapRedPacket")
    @ResponseBody
    public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
        // ÇÀºì°ü
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "ÇÀºì°ü³É¹¦" : "ÇÀºì°üÊ§°Ü");
        return retMap;
    }
}
