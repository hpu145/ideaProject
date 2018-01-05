package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangyu on 2017/10/28.
 */
public class SpringTest {
    @Test
    public void test() {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.save();








        /*//获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器获取Bean
        UserDao userDao = (UserDao)applicationContext.getBean("userDAO");
        UserDao userDao2 = (UserDao)applicationContext.getBean("userDAO");
        System.out.println(userDao == userDao2);
        userDao.save();*/
    }
}
