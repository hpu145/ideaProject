package com.kaishengit.dao;

import com.kaishengit.BaseTest;
import com.kaishengit.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangyu on 2017/10/30.
 */
public class UserDaoTest extends BaseTest{
    @Autowired
    private UserDao userDao;
    @Test
    public void save() {
        User user = new User();
        user.setUserName("小明");
        user.setAddress("河南");
        user.setPassword("12");
        user.setCountryId(1);
        userDao.save(user);
    }

    @Test
    public void findById() {
        User user = userDao.findById(3);
        System.out.println(user);
    }
    @Test
    public void findAll() {
        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
       /* for(int i=0;i<userList.size();i++) {
            System.out.println(userList.get(i));
        }*/
        /*int size = userList.size();
        int i = 0;
        while (size>0) {
            System.out.println(userList.get(i));
            i++;
            size = size - 1;
        }*/

    }
    @Test
    public void count() {
        Long num = userDao.count();
        System.out.println(num);
    }



}
