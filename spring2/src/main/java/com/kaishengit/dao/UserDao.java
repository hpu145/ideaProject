package com.kaishengit.dao;

import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/30.
 */
@Component
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User user) {
        String sql = "insert into t_user (user_name,address,password,country_id) values (?,?,?,?)";
        jdbcTemplate.update(sql,user.getUserName(),user.getAddress(),user.getPassword(),user.getCountryId());
    }


    public User findById(Integer id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(),id);
    }

    public List<User> findAll() {
        String sql = "select * from t_user";
        //return jdbcTemplate.query(sql, new UserRowMapper());
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setAddress(resultSet.getString("address"));
            user.setPassword(resultSet.getString("password"));
            user.setCountryId(resultSet.getInt("country_id"));
            return user;
        }
    }

    public Long count() {
        String sql = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql,Long.class);
    }




}
