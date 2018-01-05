package com.kaishengit.test;

import com.kaishengit.proxy.Lenovo;
import com.kaishengit.proxy.Sales;
import com.kaishengit.proxy.jdk.MyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class JdkProxyTest {
    @Test
    public void jdkProxy() {
        Lenovo lenovo = new Lenovo();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(lenovo);
        //产生的代理类需要接口指向代理类
        Sales sales = (Sales) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                                            lenovo.getClass().getInterfaces(),invocationHandler);
        sales.salePC();
    }


}
