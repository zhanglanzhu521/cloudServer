package com.zlz.springListenerDemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Title :定义无序监听器
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 20:58
 */
@Component
public class LisiListener implements ApplicationListener<ApplicationEvent>{
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof ContentEvent) {
            System.out.println("收到内容" + event.getSource() + event.getTimestamp());
        } else {
            System.out.println("类型无法匹配，无法处理的消息");
        }




    }
}
