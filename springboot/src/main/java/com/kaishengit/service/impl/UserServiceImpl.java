package com.kaishengit.service.impl;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(String userName,String passWard) {
        userDao.save(userName,passWard);

    }

    @Override
    public void saveuser(User user) {
        userMapper.save(user);
    }

}
