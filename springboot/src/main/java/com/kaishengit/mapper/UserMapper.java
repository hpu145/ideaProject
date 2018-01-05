package com.kaishengit.mapper;


import com.kaishengit.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void save(User user);


}
