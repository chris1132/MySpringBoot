package com.boot1.chovy.controller.login;

import com.boot1.chovy.service.Wechat.WechatService;
import com.boot1.chovy.util.bean.SessionUser;
import com.boot1.chovy.util.httputil.response.Code2SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangchaohui on 2018/5/10.
 */
@RestController
public class WechatLoginController {

    @Autowired
    private WechatService wechatService;

    @RequestMapping(value = "/codeCheck",method = RequestMethod.POST)
    @ResponseBody
    public String check(@RequestParam(value = "code",required = true) String code,
            HttpServletRequest req, HttpServletResponse res) throws Exception{
        Code2SessionResponse result = wechatService.code2Session(code);

        String value = result.getOpenid()+"_"+result.getSession_key();
        String thirdSessionId = wechatService.getThirdSession(value);
        req.getSession().setAttribute(thirdSessionId,new SessionUser(value,null,null,null));
        return thirdSessionId;
    }

    //TODO检查平台第三方session的有效性
    @RequestMapping(value = "/thirdSessionIdCheck",method = RequestMethod.POST)
    @ResponseBody
    public int thirdSessionIdCheck(HttpServletRequest req, HttpServletResponse res,
                                      @RequestParam(value = "thirdSessionId",required = true)String thirdSessionId){
        SessionUser sessionUser = (SessionUser)req.getSession().getAttribute(thirdSessionId);
        return sessionUser==null? 0:1;
    }
}
