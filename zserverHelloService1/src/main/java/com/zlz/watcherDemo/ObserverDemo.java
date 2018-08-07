package com.zlz.watcherDemo;

/**
 * @Title :测试
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-28 23:48
 */
public class ObserverDemo {


    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//受查者
        Watcher watcher = new Watcher();//观察者
        Watcher watcher1 = new Watcher();//观察者
        beingWatched.addObserver(watcher);
        beingWatched.addObserver(watcher1);
        beingWatched.counter(10);
    }

}
