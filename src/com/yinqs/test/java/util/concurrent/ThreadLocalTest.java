package com.yinqs.test.java.util.concurrent;

import java.util.stream.IntStream;

/**
 * ThreadLocal示例
 *
 * 本质上，ThreadLocal是通过空间来换取时间，从而实现每个线程当中都会有一个变量的副本，
 * 这样的话，每个线程都会操作该副本，从而避免了多线程的并发问题
 *
 * Java中的四种类型引用：
 *  1.强引用（Strong）一个对象被强引用（new），那么这个对象不会被GC回收
 *  2.软引用（Soft） 当内存空间不够的时候，软引用可被回收
 *  3.弱引用（Weak）会在下一次GC的时候，弱引用会被回收
 *  3.虚引用（Phantom）被回收时触发一些操作
 *
 *  public class Test{
 *      private static final ThreadLocal<String> t1 = new ThreadLocal();
 *
 *      ...
 *
 *      try{
 *          ...
 *      }finally{
 *          // 防止内存泄露
 *          t2.remove();
 *      }
 *  }
 *
 * @author yinqs
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("main thread");

        System.out.println(threadLocal.get());

        IntStream.range(0,3).forEach(i->{
            new Thread(threadLocal::get,"thread->"+i).start();
        });

    }

}
