package com.yinqs.test.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {


        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader rootLoader = classLoader.loadClass("java.lang.String").getClassLoader();

        System.out.println("java.lang.String的类加载器"+rootLoader);
        System.out.println("-----------------------");
        ClassLoader extLoader = classLoader.loadClass("com.sun.nio.zipfs.ZipInfo").getClassLoader();

        System.out.println("com.sun.nio.zipfs.JarFileSystemProvider的类加载器"+extLoader);
        System.out.println("-----------------------");

        System.out.println("本类的类加载器"+classLoader);
        System.out.println("-----------------------");
    }
}
