package com.kaishengit.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangyu on 2017/11/24.
 */
public class ShiroTestCase {


    @Test
    public void hello() {
        //1.读取shiro.ini配置文件 创建SecurityManager工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3.设置SecurityManager
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tom", "123456");

        try {
            //6.登录
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }
        //7.安全退出
        subject.logout();
    }

    @Test
    public void helloWithRealm() {
        //1.读取shiro.ini配置文件 创建SecurityManager工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2.获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3.设置SecurityManager
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tom", "123456");

        try {
            //6.登录
            subject.login(usernamePasswordToken);
            System.out.println("登录成功");
        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }
        //7.安全退出
        subject.logout();
    }


    @Test
    public void checkSubjectRole() {
        //1.读取shiro.ini配置文件 创建SecurityManager工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-roles.ini");
        //2.获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3.设置SecurityManager
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tom", "123456");
        try {
            //6.登录
            subject.login(usernamePasswordToken);
            System.out.println("登录成功");
            //判断subject是否是admin
            System.out.println("is Admin? " + subject.hasRole("admin"));
            System.out.println("is Boss? " + subject.hasRole("Boss"));
            System.out.println("is Admin and CEO? " + subject.hasAllRoles(Arrays.asList("admin","CEO")));
            boolean[] results = subject.hasRoles(Arrays.asList("admin","CEO","CFO"));
            for (boolean res : results) {
                System.out.println(res);
            }

        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }
        //7.安全退出
        subject.logout();

    }





}
