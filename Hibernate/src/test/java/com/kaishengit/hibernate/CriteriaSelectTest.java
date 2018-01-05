package com.kaishengit.hibernate;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * 使用Criteria进行查询
 * Created by zhangyu on 2017/11/28.
 */
public class CriteriaSelectTest {

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

    /**
     * 查询全部
     */
    @Test
    public void find() {
        Criteria criteria = session.createCriteria(User.class);
        Criterion userNameCriterion = Restrictions.eq("userName","zhangyu");
        Criterion passWardCriterion = Restrictions.eq("passWard","000004");
        // or 关系
        //criteria.add(Restrictions.or(userNameCriterion,passWardCriterion));

        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(userNameCriterion);
        disjunction.add(passWardCriterion);
        criteria.add(disjunction);
        List<User> userList =  criteria.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findOrder() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));
        criteria.addOrder(Order.asc("userName"));
        List<User> userList =  criteria.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void page() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);
        List<User> userList =  criteria.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void count() {
        Criteria criteria = session.createCriteria(User.class);
        ProjectionList projectionList = Projections.projectionList();

        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));
        criteria.setProjection(projectionList);

        Object[] data = (Object[]) criteria.uniqueResult();
        System.out.println("rowCount --> " + data[0]);
        System.out.println("maxId --> " + data[1]);
    }

    @Test
    public void findNativeSql() {
        String sql = "select * from user where id = ? order by id desc";
        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(User.class);
        //给占位符加参数 hiberate从0开始
        sqlQuery.setParameter(0,4);
        List<User> userList = sqlQuery.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }






}
