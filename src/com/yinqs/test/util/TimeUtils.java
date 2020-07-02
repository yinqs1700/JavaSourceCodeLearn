package com.yinqs.test.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具
 *
 * @author yinqs
 */
public class TimeUtils {


    private static long startTime;


    private TimeUtils() {

    }

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void testTime() {
        long endTime = System.currentTimeMillis();
        System.out.println("执行了--->"+(endTime - startTime)/100+"ms");
    }

}
