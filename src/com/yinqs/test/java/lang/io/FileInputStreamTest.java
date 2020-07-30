package com.yinqs.test.java.lang.io;

import java.io.*;
import java.net.URI;

public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {

        FileInputStream stream = new FileInputStream(new File("D:\\IdeaProjects\\JavaSourceCodeLearn\\src\\com\\yinqs\\test\\Main.java"));

        byte[] bytes = new byte[16];

        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = stream.read(bytes)) != -1){
            System.out.print(new String(bytes));
        }

    }

}

class FileTest{

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\IdeaProjects\\JavaSourceCodeLearn\\javaiotest1");

        boolean exists = file.exists(); // 如果一开始不存在则为true，否则false
        System.out.println("directory exists: "+exists);
        // 创建目录
        file.mkdir();

        exists = file.exists(); // true
        System.out.println("directory exists: "+exists);

        String path = file.getPath();
        System.out.println("directory path: "+path);

        file.isDirectory(); // true

        // 获得绝对路径
        String absolutePath = file.getAbsolutePath();

        System.out.println("absolutePath: "+absolutePath);

        // 获得上一级文件
        File parentFile = file.getParentFile();
        System.out.println("parent file: "+parentFile);

        // 获取上级目录
        String parent = file.getParent();
        System.out.println("parent: "+parent);

        // 转换为uri
        URI uri = file.toURI();
        System.out.println(uri.toString());

        String canonicalPath = file.getCanonicalPath();

        System.out.println("canonicalPath: "+canonicalPath);

        // 删除文件或者目录
        file.delete();

    }

}

class FileReaderTest{

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D:\\IdeaProjects\\JavaSourceCodeLearn\\src\\com\\yinqs\\test\\Main.java");

        char[] chars = new char[512];

        int len = 0;
        while ((len = reader.read(chars)) != -1){
            System.out.print(new String(chars));
        }

    }

}
