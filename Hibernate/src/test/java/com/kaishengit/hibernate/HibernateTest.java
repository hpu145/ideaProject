package com.kaishengit.hibernate;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.util.List;

/**
 * Hibernate的测试用例
 * Created by zhangyu on 2017/11/27.
 */
public class HibernateTest {

    @Test
    public void save() {
        //1.读取classpath中hibernate的配置文件 hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //2.创建SessinFactory
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //3.创建session
        Session session = sessionFactory.getCurrentSession();
        //4.创建事务
        Transaction transaction = session.beginTransaction();
        //5.执行操作
        User user = new User();
        user.setUserName("zhangyu");
        user.setPassWard("000002");

        session.save(user);
        //6.提交或回滚事务
        // 不需要再session.close()来释放资源
        transaction.commit();
    }

    @Test
    public void findById() {
        //1.从工具类获取session
        Session session = HibernateUtil.getSession();
        //2.创建事务
        Transaction transaction =  session.beginTransaction();
        User user = (User) session.get(User.class,1);
        transaction.commit();

        //System.out.println(user);
    }

    @Test
    public void deleteById() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //先查找，再执行删除
        User user = (User) session.get(User.class,2);
        session.delete(user);

        transaction.commit();
    }

    @Test
    public void findAll() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //HQL from后跟的是对应的类而不是表
        String hql = "from User order by id desc";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();

        for (User user : userList) {
            System.out.println(user);
        }
        //提交事务
        transaction.commit();
    }


}


