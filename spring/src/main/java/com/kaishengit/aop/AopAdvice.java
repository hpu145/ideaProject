package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class AopAdvice {
    public void beforeAdvice() {
        System.out.println("前置通知");
    }
    public void afterReturning() {
        System.out.println("后置通知");
    }
    public void exceptionAdvice() {
        System.out.println("异常通知");
    }
    public void after() {
        System.out.println("最终通知");
    }
    //环绕通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("before......");
            Object result = joinPoint.proceed(); //目标对象方法的执行
            System.out.println("after.......");
        } catch (Throwable throwable) {
            System.out.println("exception....");
        } finally {
            System.out.println("finally.....");
        }
    }


}
