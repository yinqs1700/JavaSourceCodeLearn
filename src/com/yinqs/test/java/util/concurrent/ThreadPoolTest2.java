package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 线程池重要的参数：
 *  int corePoolSize, 线程池中一直维护的线程数量
 *  int maximumPoolSize, 线程池中所维护的线程数最大数量
 *  long keepAliveTime, 线程池中线程数量超过corePoolSize的线程数量被回收的时间
 *  TimeUnit unit, 存活时间的时间单位
 *  BlockingQueue<Runnable> workQueue, 向线程池中所提交任务的阻塞队列
 *  ThreadFactory threadFactory, 用来创建新的线程并被线程池管理，默认线程优先级都为正常优先级
 *  RejectedExecutionHandler handler
 *
 *  AbortPolicy：直接抛异常
 *  DiscardPolicy：丢弃不能执行的任务
 *  DiscardOldestPolicy：丢弃最老的任务（即将阻塞队列任务中的对头直接出队），
 *                       将传入的任务再放入队列
 *
 * @author yinqs
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0,10).forEach(i->{
            threadPool.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                IntStream.range(0,50).forEach(j->{
                    System.out.println(Thread.currentThread().getName());
                });
            });
        });

        // 关闭线程池
        threadPool.shutdown();

    }
}
