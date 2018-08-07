package com.zlz.springListenerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 21:06
 */
@RestController
public class TestMain {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/listener")
    public String testListenner(){
        applicationContext.publishEvent(new ContentEvent("能看到消息嘛？？？？？"));

        return "收到了";
    }
}
