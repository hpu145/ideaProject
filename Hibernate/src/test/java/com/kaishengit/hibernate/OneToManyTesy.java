package com.kaishengit.hibernate;

import com.kaishengit.pojo.Address;
import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangyu on 2017/11/28.
 */
public class OneToManyTesy {

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
    public void findAddr() {
        Address address = (Address) session.get(Address.class,3);
        System.out.println(address.getAddress() + "-->" + address.getTel());
//        User user = address.getUser();
//        System.out.println(user.getUserName() + "-->" + user.getPassWard());

    }

    @Test
    public void findUser() {
        User user = (User) session.get(User.class,1);
        System.out.println("输出user：" + user.getUserName());

        Set<Address> addressSet = user.getAddressSet();
        for (Address address : addressSet) {
            System.out.println(address.getId() + "-->" + address.getAddress() + "-->" + address.getTel());
        }
        /*Criteria criteria = session.createCriteria(Address.class);
        criteria.add(Restrictions.eq("user.id",user.getId()));
        List<Address> addressList = criteria.list();
        for (Address address : addressList) {
            System.out.println(address.getAddress() + "-->" + address.getTel());
        }*/
    }



    @Test
    public void save() {
        User user = new User();
        user.setUserName("李雷");
        user.setPassWard("lilei");
        session.save(user);
    }

    @Test
    public void saveAddress() {
        //先查找出来给哪个对象添加地址
        User user = (User) session.get(User.class,6);

        Address address = new Address();
        address.setAddress("NewYork");
        address.setTel("911");
        address.setUser(user);

        session.save(address);
    }


    @Test
    public void saveAddresses() {
        User user = new User();
        user.setUserName("韩梅梅");
        user.setPassWard("hanmeimei");

        Address address = new Address();
        address.setAddress("shanghai");
        address.setTel("520");
        address.setUser(user);

        Address address1 = new Address();
        address1.setAddress("beijing");
        address1.setTel("521");
        address1.setUser(user);

        session.save(user);
        session.save(address);
        session.save(address1);
    }

    @Test
    public void delete() {
        Criteria criteria = session.createCriteria(Address.class);
        criteria.add(Restrictions.eq("user.id",4));
        List<Address> addressList = criteria.list();
        //先删除含有外键的address
        for (Address address : addressList) {
            session.delete(address);
        }
        //再删除user
        User user = (User) session.get(User.class,4);
        session.delete(user);
    }

    @Test
    public void delete2() {
        User user = (User) session.get(User.class,7);
        session.delete(user);
    }




}
