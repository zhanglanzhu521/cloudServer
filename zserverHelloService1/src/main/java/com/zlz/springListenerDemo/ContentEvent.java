package com.zlz.springListenerDemo;

import org.springframework.context.ApplicationEvent;

/**
 * @Title :定义事件
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 20:56
 */
public class ContentEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ContentEvent(final Object source) {
        super(source);
    }
}
