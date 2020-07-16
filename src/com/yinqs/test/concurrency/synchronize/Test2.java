package com.yinqs.test.concurrency.synchronize;

/**
 * JMM 以及happen-before
 *
 * @author yinqs
 */
public class Test2 {

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
