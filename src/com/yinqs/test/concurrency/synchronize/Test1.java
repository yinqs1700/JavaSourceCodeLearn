package com.yinqs.test.concurrency.synchronize;

public class Test1 {

    private Object object = new Object();

    public void method(){
        synchronized (object){
            System.out.println("hello world");
        }
    }
}
