package com.kaishengit.service;

import com.kaishengit.entity.User;

public interface UserService {

    void save(String userName,String passWard);

    void saveuser(User user);
}
