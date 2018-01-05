package com.kaishengit.hibernate;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhangyu on 2017/11/29.
 */
public class CacheTest {
   /* private Session session;
    @Before
    public void before() {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }*/


   /* @Test
    public void findUser() {
        User user = (User) session.get(User.class,6);
        session.evict(user);
        System.out.println(session.contains(user)); //false
        User user2 = (User) session.get(User.class,6);
        User user3 = (User) session.get(User.class,6);
    }*/


    @Test
    public void cache() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        User user = (User) session.get(User.class,6);
        session.getTransaction().commit();

        //获取二级缓存对象
        Cache cache = HibernateUtil.getSessionFactory().getCache();
        cache.evictEntityRegion(User.class);
        //cache.evictAllRegions();

        Session session2 = HibernateUtil.getSession();
        session2.getTransaction().begin();
        User user2 = (User) session2.get(User.class,6);
        session2.getTransaction().commit();
    }



}
