package com.zlz.listenDemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Title :监听器模式 事件源对象
 * @Description :事件源相当于单击按钮事件当中的按钮对象、属于被监听者 事件源经过事件的封装传给监听器，
 *               当事件源触发事件后，监听器接收到事件对象可以回调事件的方法
 * @Author : zhanglz
 * @Date : 2018-07-28 23:58
 */
public class DemoSource {
    private Vector repository = new Vector();//监听自己的监听器队列
    public DemoSource(){}
    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }

    /***
    * @Title 通知
    * @Description
    * @Author  zhanglz
    * @Date  2018-07-29 0:08
    * @param
    * @return  void
    */
    public void notifyDemoEvent(){
        Enumeration enumeration = repository.elements();
        while (enumeration.hasMoreElements()) {
            DemoListener demoListener = (DemoListener) enumeration.nextElement();
            demoListener.handleEvent(new DemoEvent(this));
        }
    }



}
