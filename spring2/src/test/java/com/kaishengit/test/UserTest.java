package com.kaishengit.test;

import com.kaishengit.BaseTest;
import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class UserTest extends BaseTest{
    @Autowired
    private UserDao userDao;
    @Test
    public void save() {
        User user = new User();
        user.setUserName("小明");
        user.setAddress("河南");
        user.setPassword("123");
        user.setCountryId(1);
        userDao.save(user);
    }

}
