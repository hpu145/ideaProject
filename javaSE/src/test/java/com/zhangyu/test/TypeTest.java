package com.zhangyu.test;

import org.junit.Test;

import java.lang.reflect.Field;

public class TypeTest {
    private int a = 5;
    private double b = 5.0;
    @Test
    public void mytest() {
        //运算结果的数据类型总是和数据类型范围大的相同
        double c = a + b;
        //true
        //基本数据类型来说，==比较的是数值，和类型无关
        System.out.println(a == b);
    }

    //利用java的反射机制，判断输出已声明变量的所属类型
    public static void main(String[] args) {
        double i = 3.0;
        String type = getTypeFromObj(i);
        System.out.println(type);

    }
    private static String getTypeFromObj(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        System.out.println(fields.length);
        String type = null;
        for (int i = 0;i < fields.length;i++) {
            type = fields[i].getType().toString();
            break;
        }
        return type;
    }

}
