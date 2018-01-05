package com.kaishengit.pojo;

/**
 * Created by zhangyu on 2017/11/28.
 */
public class Address {

    private Integer id;
    private String address;
    private String tel;
    private User user;

    //get set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
