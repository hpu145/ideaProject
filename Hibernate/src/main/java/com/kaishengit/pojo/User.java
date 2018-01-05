package com.kaishengit.pojo;

import java.util.Set;

/**
 * Created by zhangyu on 2017/11/27.
 */
public class User {

    private Integer id;
    private String userName;
    private String passWard;
    private Set<Address> addressSet;

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWard() {
        return passWard;
    }

    public void setPassWard(String passWard) {
        this.passWard = passWard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWard='" + passWard + '\'' +
                '}';
    }
}
