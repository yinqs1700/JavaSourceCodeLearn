package com.yinqs.test.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Integer 相关
 *  1.Integer不“使用”new创建对象的时候，通过字节码反编译可以看出实际上是调用了
 *    Integer.valueOf(int value)的静态方法创建的对象，则当值为-128~127时会直接返回
 *    之前已经创建好的对象，因此当Integer使用int产生对象的时候，值在-128~127之前的时候，
 *    使用==比较，会返回true，因为本质上两个对象是相同的。
 *  2.当int值和Integer比较的时候，字节码层面上会首先调用integer的intValue自动拆箱，之后
 *    再与int值进行比较，如果相等则会返回true。
 *
 * @author yinqs
 */
public class IntegerTest {

    public static void main(String[] args) throws IOException {

        int a = 1000;
        int b = 1000;

        Integer aa = 127;
        Integer bb = 127;
        Integer cc = new Integer(129);

        Integer AA = 1000;
        Integer BB = 1000;

//        System.out.println(a==b);
        System.out.println(aa==bb); // true
        System.out.println(aa==cc); // false
        System.out.println(AA==BB);
        System.out.println(a==AA);
//        System.out.println(a==BB);
    }
}
