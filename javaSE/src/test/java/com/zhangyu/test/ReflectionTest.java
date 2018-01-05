package com.zhangyu.test;

import com.zhangyu.entity.User;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * java的反射机制
 * Created by zhangyu on 2017/12/1.
 */
public class ReflectionTest {

    /**
     *  反射机制获取类有3种方法
     */
    @Test
    public void getClassTset() throws ClassNotFoundException {

        //1.直接通过类名.class得到
        Class clazz = User.class;
        System.out.println("通过类名得到：" + clazz);
        //class com.zhangyu.entity.User

        //2.通过对象的getClass()方法得到
        User user = new User();
        Class clazz2 = user.getClass();
        System.out.println("通过对象的getClass()方法得到：" + clazz);
        //class com.zhangyu.entity.User

        //3.通过全类名获取，需要写完全限定名
        // 用的较多，但可能抛出ClassNotFoundException异常
        Class clazz3 = Class.forName("com.zhangyu.entity.User");
        System.out.println("通过全类名得到：" + clazz);
    }


    /**
     * 利用Class的newInstance方法创建对象
     */
    @Test
    public void getNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.zhangyu.entity.User");

        //实际上调用的是User类的无参数的构造方法
        // 在写类的时候要提供一个无参的构造方法，就是给反射用的
        //一般，一个类要声明了有参的构造方法，同时也要声明一个无参的构造方法
        Object object = clazz.newInstance();
        System.out.println(object);

    }


    /**
     * 对user中的方法进行测试
     */
    @Test
    public void userMethodTest() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("com.zhangyu.entity.User");

        //1.获取clazz类对应的有哪些方法，但不能获取私有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("clazz类中的public方法：" + method.getName());
        }

        //2.获取所有的方法，只获取当着类声明的方法，包括私有方法
        Method[] methods1 = clazz.getDeclaredMethods();
        System.out.println("\ngetDeclaredMethods: ");
        for (Method method : methods1) {
            System.out.println(method.getName());
        }

        //3.获取指定的方法
        //第一个参数是方法名，后面的是方法里的参数
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println("\nsetName :" + method);

    }



}
