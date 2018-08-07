package com.zlz.listenDemo;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-07-29 0:04
 */
public class TestMain {
    DemoSource ds;
    public TestMain(){
        try{
            ds = new DemoSource();
            //将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            ds.addDemoListener(listener1);
            ds.addDemoListener(new DemoListener() {
                public void handleEvent(DemoEvent event) {
                    System.out.println("Method come from 匿名类...");
                }
            });
            ds.notifyDemoEvent();//触发事件、通知监听器
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestMain();
    }

}
