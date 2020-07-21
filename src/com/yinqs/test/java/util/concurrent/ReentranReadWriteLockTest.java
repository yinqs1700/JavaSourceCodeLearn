package com.yinqs.test.java.util.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentranReadWriteLockTest
 *
 * @author yinqs
 */
public class ReentranReadWriteLockTest {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        // 缓存是否有效
        if (!cacheValid) {
            // 在获取写锁之前必须先释放读锁
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
//                    data = ...
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
//            use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}
