package com.yinqs.test.thread.chapter01.usingthread;

import com.yinqs.test.thread.chapter01.usingthread.MyThread;

/**
 * @author yinqs
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.setName("myThread");
        // 开启线程
        thread.start();
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random()*1000);
            Thread.sleep(time);
            System.out.println("main="+Thread.currentThread().getName());
        }
    }
}
