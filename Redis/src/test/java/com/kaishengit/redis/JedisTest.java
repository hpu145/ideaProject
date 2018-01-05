package com.kaishengit.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jedis的使用测试
 * Created by zhangyu on 2017/12/4.
 */
public class JedisTest {

    //普通连接
    //存值
    @Test
    public void setString() {
        Jedis jedis = new Jedis("192.168.253.30",6379);
        jedis.set("username:01","jack");
        jedis.close();
    }
    //取值
    @Test
    public void getString() {
        Jedis jedis = new Jedis("192.168.253.30",6379);
        String res = jedis.get("username:01");
        System.out.println(res);
        jedis.close();
    }
    @Test
    public void setList() {
        Jedis jedis = new Jedis("192.168.253.30",6379);
        jedis.lpush("address:01","北京","NewYork");
        jedis.close();
    }

    @Test
    public void getList() {
        Jedis jedis = new Jedis("192.168.253.30",6379);
        List<String> list = jedis.lrange("address:01",0,-1);
        for (String str : list) {
            System.out.println(str);
        }
        jedis.close();
    }

    //连接池连接

    @Test
    public void jedisPool() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMinIdle(3);

        JedisPool jedisPool = new JedisPool("192.168.253.30",6379);
        Jedis jedis = jedisPool.getResource();

        Map<String,String> data = new HashMap<>();
        data.put("id","1");
        data.put("age","26");
        data.put("address","shanghai");

        //jedis.hmset("user:01",data);
        Map<String,String> res = jedis.hgetAll("user:01");
        System.out.println(res.get("id"));
        System.out.println(res.get("age"));
        System.out.println(res.get("address"));
        jedis.close();
        jedisPool.destroy();
    }





}
