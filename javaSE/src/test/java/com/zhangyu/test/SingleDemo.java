package com.zhangyu.test;

import com.zhangyu.entity.Dog;

/**
 * 单例模式
 */
public class SingleDemo {
    //懒汉式
    private static Dog dog;

    private SingleDemo() {

    }
    public static Dog getSingleDemo() {
        if (dog == null) {
            dog = new Dog();
        }
        return dog;
    }
}
//饿汉式
class SingleDemo2 {
    private static Dog dog = new Dog();

    private SingleDemo2() {

    }

    public static Dog getSingleDemo() {
        return dog;
    }


}
