package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 *
 * ReentrantLock
 *  1.尝试获取对象的锁，如果获取不到，那么他就会进入到AQS的阻塞队列当中
 *  2.如果获取到，那么根据锁是公平锁还是非公平锁来进行不同的处理
 *      - 公平锁：线程会直接放置到AQS的阻塞队列的末尾
 *      - 非公平锁：线程会首先尝试进行CAS计算。如果成功，直接获取到锁，
 *        如果失败，则与公平锁的处理方式一致，放置到阻塞队列的末尾
 *  3.当锁释放时，那么底层会调用release方法对state成员变量-1操作，如果-1之后state
 *    不为0，那么release操作就执行完毕，如果state为0，则调用LockSupport的unpark
 *    方法唤醒线程后的等到队列中的第一个后继线程，将其唤醒，使之能够获取到对象的锁，
 *    release之后state可能不为0的原因是ReentrantLock是可重入锁，每次当前线程调用
 *    一次lock方法，state就+1。
 *  上锁的本质，就是通过对AQS中的state成员变量进行操作，+1上锁，-1释放锁。
 *
 * @author yinqs
 */
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            System.out.println("method1");
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            System.out.println("method2");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantLockTest test = new ReentrantLockTest();

        IntStream.range(0, 2).forEach(i -> {
            new Thread(() -> {
                while (true) {
                    test.increment();
                }
            }, "upThread-" + i).start();
        });


        IntStream.range(0, 2).forEach(i -> {
            new Thread(() -> {
                while (true) {
                    test.decrement();
                }
            }, "downThread-" + i).start();
        });

    }
}
