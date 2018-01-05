package com.kaishengit.redis;

import com.alibaba.fastjson.JSON;
import com.kaishengit.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Spring与Jedis整合进行测试
 * Created by zhangyu on 2017/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jedis.xml")
public class SpringJedisTest {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void setString() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("username:02","lucy");
        jedis.close();
    }

    //存放Entity  引入fastJson
    @Test
    public void setUser() {
        User user = new User(1,"Obama","65","美国");
        Jedis jedis = jedisPool.getResource();
        jedis.set("user:obama", JSON.toJSONString(user));
        jedis.close();
    }
    @Test
    public void getUser() {
        Jedis jedis = jedisPool.getResource();
        User user = JSON.parseObject(jedis.get("user:obama"),User.class);
        System.out.println(user);
        jedis.close();
    }







}
