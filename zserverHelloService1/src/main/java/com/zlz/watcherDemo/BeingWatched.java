package com.zlz.watcherDemo;

/**
 * @Title :被观察者
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-28 23:47
 */
public class BeingWatched extends java.util.Observable {

    void counter(int period) {
        for(; period>=0; period-- ) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch( InterruptedException e) {
                System.out.println("Sleep interrupeted" );
            }
        }
    }
}
