package com.yinqs.test.jmm;


import java.util.ArrayList;
import java.util.List;

/**
 * 测试OOM
 * @author yinqs
 */
public class OomTest {

    public static void main(String[] args) {

        // -Xms20m -Xmx20m 修改JVM参数指定堆大小为20MB
        List<Object> list = new ArrayList<>();

        while (true){
            System.out.println("添加成功："+list.add(new Object()));
        }

    }
}
