package com.kaishengit.test;

import com.kaishengit.proxy.Lenovo;
import com.kaishengit.proxy.Proxy;
import org.junit.Test;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class ProxyTest {

    @Test
    public void proxy() {
        Lenovo lenovo = new Lenovo();
        Proxy proxy = new Proxy(lenovo);
        proxy.salePC();
    }


}
