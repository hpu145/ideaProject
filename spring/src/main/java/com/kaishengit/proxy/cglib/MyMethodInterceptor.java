package com.kaishengit.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class MyMethodInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("before 前置通知");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("after 后置通知");
        return result;
    }
}
