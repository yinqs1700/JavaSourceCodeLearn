package com.yinqs.test.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {

        Callable<Integer> callable = ()->{
            System.out.println("pre execute");
            int randomNumber = new Random().nextInt(500);
            Thread.sleep(5000);
            System.out.println("callable execute");
            return randomNumber;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();
        System.out.println("thread started");

        try {
            Thread.sleep(2000);
            System.out.println("异步任务"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
