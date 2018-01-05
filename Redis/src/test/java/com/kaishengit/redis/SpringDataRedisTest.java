package com.kaishengit.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Data Redis测试类
 * Created by zhangyu on 2017/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jedis.xml")
public class SpringDataRedisTest {

    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    public void setString() {
        redisTemplate.opsForValue().set("data:name","bigData");
    }
    @Test
    public void getString() {
        String val = redisTemplate.opsForValue().get("data:name");
        System.out.println(val);
    }






}
