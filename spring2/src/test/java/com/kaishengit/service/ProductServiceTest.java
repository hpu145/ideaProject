package com.kaishengit.service;

import com.kaishengit.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class ProductServiceTest {

        @Test
        public void save() {
            ApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(Application.class);
                    //new ClassPathXmlApplicationContext("applicationContext.xml");
            ProductService productService = (ProductService) applicationContext.getBean("productService");
            productService.save();
    }




}
