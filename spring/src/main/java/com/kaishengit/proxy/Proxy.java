package com.kaishengit.proxy;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class Proxy implements Sales {
   private Sales sales;
   public Proxy(Sales sales) {
       this.sales = sales;
   }

    @Override
    public void salePC() {
        sales.salePC();
    }
}
