package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yinqs
 * 使用阻塞队列实现生产者消费者模式
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) {

        LinkedBlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>(5);

        new Consumer(blockingQueue,"consumer1").start();

        new Consumer(blockingQueue,"consumer2").start();

        new Provider(blockingQueue).start();

    }

}


class Consumer extends Thread{

    LinkedBlockingQueue<Object> queue;

    public Consumer(LinkedBlockingQueue<Object> queue,String name) {
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

class Provider extends Thread{

    LinkedBlockingQueue<Object> queue;

    public Provider(LinkedBlockingQueue<Object> queue) {
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
