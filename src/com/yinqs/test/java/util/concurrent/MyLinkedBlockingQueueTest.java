package com.yinqs.test.java.util.concurrent;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author yinqs
 * 使用阻塞队列实现生产者消费者模式
 */
public class MyLinkedBlockingQueueTest {

    public static void main(String[] args) {

        MyLinkedBlockingQueue<Object> blockingQueue = new MyLinkedBlockingQueue<>(5);

        new Consumer1(blockingQueue,"consumer1").start();


        new Provider1(blockingQueue).start();

    }

}


class Consumer1 extends Thread{

    MyLinkedBlockingQueue<Object> queue;

    public Consumer1(MyLinkedBlockingQueue<Object> queue,String name) {
        this.queue = queue;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"消费了一个Object："+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Provider1 extends Thread{

    MyLinkedBlockingQueue<Object> queue;

    public Provider1(MyLinkedBlockingQueue<Object> queue) {
        this.queue = queue;
        this.setName("provider");
    }

    @Override
    public void run() {

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Object o = new Object();
                System.out.println(Thread.currentThread().getName()+"生产了一个Object："+o);
                queue.put(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
