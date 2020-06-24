package com.yinqs.test.java.util.concurrent;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinqs
 * 自定义阻塞队列:
 */
public class MyLinkedBlockingQueue<T> {

    private ReentrantLock  lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    /**
     *  队列
     */
    private LinkedList<T> value;

    /**
     * 记录当前元素
     */
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * 容量
     */
    private Integer capacity = 0;

    public MyLinkedBlockingQueue(int capacity){
        this.value = new LinkedList<>();
        this.capacity = capacity;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void put(T element){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (getCount().intValue() >= capacity){
                notFull.await();
            }
            count.incrementAndGet();
            value.offer(element);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (getCount().intValue() < 1){
                notEmpty.await();
            }
            count.decrementAndGet();
            notFull.signal();
            return value.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }
}
