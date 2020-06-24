package com.yinqs.test.thread.chapter01.usingthread;

/**
 * 实现Runnable接口开启多线程，或是匿名内部类
 * @author yinqs
 */
public class RunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"myThread");
        thread.start();

    }
}
