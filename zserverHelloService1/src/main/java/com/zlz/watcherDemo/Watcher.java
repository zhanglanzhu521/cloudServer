package com.zlz.watcherDemo;

/**
 * @Title :观察者
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-28 23:46
 */
public class Watcher  implements java.util.Observer{

    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() called, count is "
                + ((Integer) arg).intValue());
    }
}
