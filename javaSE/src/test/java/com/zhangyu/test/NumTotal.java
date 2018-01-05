package com.zhangyu.test;

public class NumTotal {

    public static void main(String[] args) {
        int num = 100;
        int total = 0;
        for (int i=0;i<=num;i++) {
            if (i % 2 == 0) {
                total = total + i;
            } else {
                total = total;
            }
        }
        System.out.println("100以内的偶数和为： " + total);
    }

}
