package com.zlz.springListenerDemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Title :定义有序的监听器
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/3 21:03
 */
@Component
public class OrderListener implements SmartApplicationListener {
    /**
     * Determine whether this listener actually supports the given event type.
     *
     * @param eventType
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType==ContentEvent.class;
    }

    /**
     * Determine whether this listener actually supports the given source type.
     *
     * @param sourceType
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType==String.class;
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("有序并且判断类型,直接处理消息"+event.getSource());
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 2;
    }
}
