package com.kaishengit.entity;

public class User {

    private Integer id;
    private String userName;
    private String  passWard;

    public User(){

    }

    public User(Integer id, String userName, String passWard) {
        this.id = id;
        this.userName = userName;
        this.passWard = passWard;
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
}
