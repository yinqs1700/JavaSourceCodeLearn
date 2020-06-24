package com.yinqs.test.thread.chapter01.usingthread;

/**
 * @author yinqs
 */
public class MyThread03 extends Thread{
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由线程"+Thread.currentThread().getName()+"计算，count="+count);
    }
}
