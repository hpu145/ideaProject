package com.kaishengit.hibernate;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by zhangyu on 2017/11/27.
 */
public class SelectTest {

    private Session session;
    @Before
    public void before() {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }

    @Test
    public void findAll() {
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() {
        String hql = "from User where id = :id";
        Query query = session.createQuery(hql);
        //query.setParameter("id",1);
        query.setInteger("id",1);
        User user = (User) query.uniqueResult();
        System.out.println(user);
    }

    @Test
    public void findIdAndUserNameAndPassword() {
        String hql = "select id,userName,passWard from User";
        Query query = session.createQuery(hql);
        List<Object[]> dataList = query.list();
        for (Object[] data : dataList) {
            System.out.println(data[0] + "-->" + data[1] + "-->" + data[2]);
        }
    }

    @Test
    public void count() {
        String hql = "select count(*),max(id) from User";
        Query query = session.createQuery(hql);
        Object[] data = (Object[]) query.uniqueResult();
        System.out.println(data[0] + " ->  " + data[1]);
    }


    //分页查询
    @Test
    public void page() {
        String hql = "from User order by id desc";
        Query query = session.createQuery(hql);
        //limit 0,5
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<User> users = query.list();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
