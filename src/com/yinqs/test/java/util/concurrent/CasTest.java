package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 *
 * @author yinqs
 */
public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndSet(8));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
