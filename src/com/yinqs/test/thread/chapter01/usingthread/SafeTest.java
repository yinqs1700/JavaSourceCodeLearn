package com.yinqs.test.thread.chapter01.usingthread;

/**
 * 当不共享数据的时候，线程之间是安全的
 * @author yinqs
 */
public class SafeTest {
    public static void main(String[] args) {
        // 由于每个线程都有自己的count值，所以count并不共享，线程之间对count的操作是安全的
        MyThread02 thread01 = new MyThread02("A");
        MyThread02 thread02 = new MyThread02("B");
        MyThread02 thread03 = new MyThread02("C");
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
