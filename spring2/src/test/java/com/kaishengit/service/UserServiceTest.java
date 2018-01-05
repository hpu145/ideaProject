package com.kaishengit.service;

import com.kaishengit.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.pipe.AlphaPaintPipe;

/**
 * Created by zhangyu on 2017/10/30.
 */


public class UserServiceTest extends BaseTest{
    @Autowired
    private  UserService userService;
    @Test
    public void save() {
        userService.save();

    }

}
