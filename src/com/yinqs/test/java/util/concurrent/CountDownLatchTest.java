package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * CountDownLatch例子
 *
 * @author yinqs
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        // 定义子任务数量
        CountDownLatch countDownLatch = new CountDownLatch(3);

        IntStream.range(0,3).forEach(i -> new Thread(()->{
            try {
                // 模拟操作耗时
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        },"线程-"+i).start());

        System.out.println("子线程启动完毕");
        try {
            // countDownLatch不归为0则主线程会被一直阻塞
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
