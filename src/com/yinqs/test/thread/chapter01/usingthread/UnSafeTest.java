package com.yinqs.test.thread.chapter01.usingthread;

/**
 * 对共享的数据进行操作造成共享问题
 * @author yinqs
 */
public class UnSafeTest {
    public static void main(String[] args) {
        // 由于thread中的count被,a,b,c,d,e共享了，则会产生数据共享的问题，导致每次运行的结果不一致
        MyThread03 thread = new MyThread03();
        Thread a = new Thread(thread,"A");
        Thread b = new Thread(thread,"B");
        Thread c = new Thread(thread,"C");
        Thread d = new Thread(thread,"D");
        Thread e = new Thread(thread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
