package com.kaishengit.proxy;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class Lenovo implements Sales {
    @Override
    public void salePC() {
        System.out.println("Lenovo 销售一台电脑!");
    }
}
