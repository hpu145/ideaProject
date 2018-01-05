package com.zhangyu.test;

import java.util.*;

/**
 * ArrayList进行迭代
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangyu");
        list.add("zhangsan");
        list.add("lihua");
        list.add(1,"123");
        System.out.println(list.size());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            System.out.println(str);
        }


    }



}
