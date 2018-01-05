package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class ProductDaoTest {
    @Test
    public void save() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductDao productDao = (ProductDao) applicationContext.getBean("productDao");
        productDao.save();
    }




}
