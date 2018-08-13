package com.db.dynamicdatasource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title :测试类
 * @Description :测试类
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
@RestController
public class BaseController {

    /**
     * Root path, The HEAD method is for SpringBoot Admin to monitor application status
     *
     * @return
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ResponseBody
    public String root() {
        return "Hello World";
    }
}
