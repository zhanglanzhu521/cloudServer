package com.zlz.common.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 15:05
 */
public class ApplicationContextInitializerTest implements org.springframework.context.ApplicationContextInitializer<ConfigurableApplicationContext> {
    /**
     * Initialize the given application context.
     *
     * @param applicationContext the application to configure
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("我被初始化了！！！！！！！！！！！！！！");
    }
}
