package com.zhangyu.entity;

/**
 * Created by zhangyu on 2017/12/1.
 */
public class User {

    private String name;
    private String password;
    private Integer age;
    private String num;

    //新增一个私有的方法
    private void privateMethod() {
        System.out.println("User的私有方法");
    }

    public User() {
        System.out.println("无参构造方法");
    }

    public User(String name,String password) {
        System.out.println("有参构造方法");
        this.name = name;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", num='" + num + '\'' +
                '}';
    }
}
