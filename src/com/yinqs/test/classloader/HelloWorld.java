package com.yinqs.test.classloader;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException {

        // 虚拟机参数verbose:class查看类加载器
        // 使用jps  或  jcmd 查看当前运行的java程序
        // 找到进程id之后，使用jcmd pid help 查看可用的命令
        System.out.println("Hello World");
        System.in.read();

        /*
            类不会重复加载（类的唯一性定义：同一个类加载器下的类名相同的类）
         */

        /*
            可以通过创建新的类加载器加载类，每次加载类时使用新的类加载器加载
            ，从而实现热加载
         */

    }
}
