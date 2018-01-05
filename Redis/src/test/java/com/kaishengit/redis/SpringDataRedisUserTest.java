package com.kaishengit.redis;

import com.kaishengit.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 在SpringDataRedis中对User对象进行操作
 * Created by zhangyu on 2017/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jedis.xml")
public class SpringDataRedisUserTest {
    private RedisTemplate<String,User> redisTemplate;
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
    }
    //存取user
    @Test
    public void saveUser() {
        User user = new User(5,"Kily","39","shanghai");
        redisTemplate.opsForValue().set("user:02",user);
    }
    @Test
    public void getUser() {
        User user = redisTemplate.opsForValue().get("user:02");
        System.out.println(user);
    }





}
