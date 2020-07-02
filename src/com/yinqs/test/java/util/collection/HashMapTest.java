package com.yinqs.test.java.util.collection;


import com.yinqs.test.util.TimeUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * hashMap测试
 * @author yinqs
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        /*

            hashCode相等  capacity 8  插入20000个对象  ----> 11s   9s   9s     9s
            hashCode相等  capacity 64 插入20000个对象  ----> 9s    9s   11s    10s

            预存对象1000 000 load factor 0.75 则容量
            重写了hashCode 和 equals
        */


        Map<Person,Integer> map = new HashMap<>(8);

        TimeUtils.start();

        for (int i = 0; i < 1000000; i++) {
            map.put(new Person(i,"aaa"+i),i);
        }

        TimeUtils.testTime();

    }

}

class Person{
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
