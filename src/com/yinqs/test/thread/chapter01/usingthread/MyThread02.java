package com.yinqs.test.thread.chapter01.usingthread;

/**
 * 1.2.3实例变量与线程安全问题
 * @author yinqs
 */
public class MyThread02 extends Thread {
    private int count = 5;

    public MyThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (count > 0){
            count--;
            System.out.println("由线程"+Thread.currentThread().getName()+"计算，count="+count);
        }
    }
}
