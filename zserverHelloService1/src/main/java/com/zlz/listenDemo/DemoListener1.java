package com.zlz.listenDemo;

/**
 * @Title :监听器实现类
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-29 0:02
 */
public class DemoListener1 implements DemoListener {
    @Override
    public void handleEvent(DemoEvent dm) {
        System.out.println("Inside listener1...");
        dm.say();//回调
    }
}
