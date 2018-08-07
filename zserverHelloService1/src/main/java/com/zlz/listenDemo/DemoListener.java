package com.zlz.listenDemo;

/**
 * @Title :事件侦听器接口
 * @Description : extends java.util.EventListener
 * @Author : zhanglz
 * @Date : 2018-07-29 0:01
 */
public interface DemoListener {
    //EventListener是所有事件侦听器接口必须扩展的标记接口、因为它是无内容的标记接口、
    //所以事件处理方法由我们自己声明如下：
    public void handleEvent(DemoEvent dm);
}
