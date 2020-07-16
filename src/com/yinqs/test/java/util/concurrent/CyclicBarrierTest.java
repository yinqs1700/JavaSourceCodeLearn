package com.yinqs.test.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * CyclicBarrier示例
 * 若干个线程等待线程，只有所有的线程都到达了Barrier的时候，所有线程才能执行
 * 1.初始化CycliBarrier各种成员变量，parties，count，Runnable
 * 2.await方法，底层计数器会检查是否归零
 *  - 如果为0，执行可选的Runnable，开始下一代（并重置count），同时调用condition的signalAll方法唤醒所有屏障前
 *    等待的线程
 *  - 计数器不为0，当前的调用线程会通过Condition的await方法，在屏障前进行等待
 * @author yinqs
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3,()->{
            System.out.println("ready to broken");
        });

        IntStream.range(0, 3).forEach(
                i-> IntStream.range(0, 3).forEach(
                        j -> new Thread(() -> {
                            try {
                                Thread.sleep((long) (Math.random() * 2000));
                                int randomInt = new Random().nextInt(500);
                                System.out.println("before broken " + randomInt);
                                barrier.await();
                                System.out.println("after broken " + randomInt);
                            } catch (InterruptedException | BrokenBarrierException e) {
                                e.printStackTrace();
                            }
                        }, "线程-" + i).start()
                )
        );

    }
}
