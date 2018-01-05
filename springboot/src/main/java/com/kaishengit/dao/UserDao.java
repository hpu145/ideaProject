package com.kaishengit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String userName, String passWard) {
        String sql = "insert into user (user_name,pass_ward) values (?,?)";
        jdbcTemplate.update(sql,userName,passWard);

    }
}
