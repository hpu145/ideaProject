package com.zhangyu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap的迭代
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map<String,String> maps = new HashMap<>();
        maps.put("K1","V1");
        maps.put("K2","V2");
        maps.put("K3","V3");

       /* //1.获得Map集合的所有键的Set集合
        Set<String> keys = maps.keySet();
        //2.迭代key的Set集合，根据每次获得的key获取value值
        for (String key : keys) {
            String value = maps.get(key);
            System.out.println("key: " + key + ";" + "value: " + value);
        }*/

       //1.获得Map集合的所有键值对的Set集合
        Set<Map.Entry<String,String>> entrySet = maps.entrySet();
        //2.迭代Set集合，每次获得一个键值对并通过getKey()、getValue()获得对应的key和value值
        for (Map.Entry<String,String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + ";" + "value: " + value);
        }



    }


}
