package com.kaishengit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyu on 2017/10/29.
 */
@Component
@Aspect
public class AopAdvice {
    @Pointcut("execution(* com.kaishengit.service..*.*(..))")
    public void pointcut(){}
    @Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("后置通知");
    }
    @AfterThrowing("pointcut()")
    public void exceptionAdvice() {
        System.out.println("异常通知");
    }
    @After("pointcut()")
    public void after() {
        System.out.println("最终通知");
    }

    //环绕通知
    //@Around("pointcut()")
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
