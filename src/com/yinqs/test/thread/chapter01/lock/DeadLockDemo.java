package com.yinqs.test.thread.chapter01.lock;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class DeadLockDemo {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() throws InterruptedException {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() +" get lock1");
            Thread.sleep(2000);
            synchronized (lock2){
                System.out.println("method1 excuted");
            }
        }
    }

    public void method2(){
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName() +" get lock2");
            synchronized (lock1){
                System.out.println("method2 excuted");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        new Thread(()->{
            try {
                deadLockDemo.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1").start();

        new Thread(()->{
            deadLockDemo.method2();
        },"thread2").start();
    }

}
