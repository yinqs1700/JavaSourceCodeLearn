package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author yinqs
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() ->
                "hello")
                .thenApplyAsync(value -> value + " world")
                .join();

        System.out.println(result);

        System.out.println("==========");


        CompletableFuture.supplyAsync(() -> "hello")
                .thenAcceptAsync(value -> System.out.println("welcome " + value));

        System.out.println("==========");

        // 对stage的合并操作
        result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world";
        }), (s1, s2) -> s1 + s2).join();

        System.out.println(result);

        System.out.println("==========");

        CompletableFuture<Void> cp = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finished");
        });

        // 非阻塞调用
        cp.whenComplete((t,action)-> System.out.println("执行完成！"));

        System.out.println("主线程执行完毕");
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
