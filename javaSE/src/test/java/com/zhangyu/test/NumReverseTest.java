package com.zhangyu.test;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 数字反转
 */
public class NumReverseTest {
    //字符串反转
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String num = input.next();
        String res = "";
        for (int i=num.length()-1;i>=0;i--) {
            res = res + num.charAt(i);
        }
        System.out.println("反转的结果为： " + res);

       /* Scanner input = new Scanner(System.in);
        System.out.println("请输入数字：");
        int inputNum = input.nextInt();
        int res;
        while(inputNum != 0) {
            res = inputNum % 10;
            System.out.print(res);
            inputNum /= 10;
        }*/

    }





}
