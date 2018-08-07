package com.zlz.springListenerDemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Title :泛型类型的监听器
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 21:01
 */
@Component
public class FXListener  implements ApplicationListener<ContentEvent>{
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContentEvent event) {
        System.out.println("泛型，不需要判断类型，直接处理:" + event.getSource());
    }
}
