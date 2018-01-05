package com.kaishengit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class MyInvocationHandler implements InvocationHandler{
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method表示目标对象target其中的一个方法  args表示方法的参数
        System.out.println("前置通知");
        Object result = method.invoke(target,args);//代表目标对象target的方法的执行
        System.out.println("后置通知");
        return result;
    }
}
