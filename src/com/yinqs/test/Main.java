package com.yinqs.test;


public class Main {

    static int count = 0;

    public static void main(String[] args) {

        f(9);
        System.out.println(count);

    }

    public static int f(int n){
        count++;
        if (n <= 2){
            return 1;
        }
        return f(n-4)+f(n-2)+1;
    }


}
