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
 *
 * 对于线程池，其提供的execute与submit两种方式向线程池提交任务，总的来说，submit方法
 * 是可以取代execute方法的，因为它即可以接受Callable任务，也可以接受Runnable任务
 *
 * 线程池执行策略：
 *  1.如果线程池中正在执行的线程数小于CorePoolSize，那么线程池就会优先选择创建新的线程而
 *    将提交的任务加入到阻塞队列当中。
 *  2.如果线程池中正在执行的线程数大于或者等于CorePoolSize，那么线程池会优先选择对提交
 *    的任务阻塞将其放入阻塞队列而不是创建新的线程。
 *  3.如果提交的任务无法加入到阻塞队列当中，线程池会创建新的线程，从阻塞队列当中poll出
 *    相应的任务；如果线程数超过了maxPoolSize，那么拒绝策略就会起到作用。
 *
 * 对于线程池来说，存在两个状态需要维护：
 *  1.线程池本身的状态
 *  2.线程池中运行着的线程数量
 *
 * @author yinqs
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),new ThreadPoolExecutor.AbortPolicy());

        //[Running, pool size = 5, active threads = 5, queued tasks = 3, completed tasks = 0]
        IntStream.range(0,9).forEach(i->{
            threadPool.submit(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                IntStream.range(0,1).forEach(j->{
                    System.out.println(Thread.currentThread().getName());
                });
            });
        });

        // 关闭线程池
        threadPool.shutdown();
    }
}
