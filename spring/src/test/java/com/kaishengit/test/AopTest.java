package com.kaishengit.test;

import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangyu on 2017/10/29.
 */
public class AopTest {

    @Test
    public void aopTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.save();

    }
}
