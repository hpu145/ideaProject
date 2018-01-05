package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.proxy.cglib.MyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class CglibProxyTest {
    @Test
    public void proxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);  //设置目标对象userDao
        enhancer.setCallback(new MyMethodInterceptor());  //设置MethodInterceptor接口的实现类
        UserDao userDao = (UserDao) enhancer.create();  //产生目标对象的子类（动态代理类）
        userDao.save();
    }
}
