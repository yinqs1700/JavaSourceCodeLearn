package com.yinqs.test;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        * 默认使用单向链表将元素串起来
        * 在添加元素时，可能会由单向链表转为红黑树来存储元素
        * 比如当哈希表容量>=64且单向链表节点数量大于8时
        *
        * 当红黑树节点数量少到一定程度的时候，又会转为单链表
        * */
        Map<String,Integer> map = new HashMap<>(65);
        map.put("aaa",1);
        map.put("bbb",2);
        map.put("ccc",2);
        map.put("ddd",2);
        map.put("eee",2);
        map.put("fff",2);
        map.put("ggg",2);
        map.put("hhh",2);
        map.put("iii",2);
        map.put("jjj",2);
        System.out.println(map.size());
    }
}
