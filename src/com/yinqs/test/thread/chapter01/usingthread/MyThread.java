package com.yinqs.test.thread.chapter01.usingthread;

/**
 * java多线程编程核心技术学习
 * java多线程实现方式一，继承Thread接口
 *
 * @author yinqs
 */
public class MyThread extends Thread {
    /**
     * 重写run方法
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

