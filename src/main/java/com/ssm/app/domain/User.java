package com.ssm.app.domain;

/**
 * Created by zhzy on 2017/11/16.
 */
public class User {


    String name;
    String password;
    Integer uid;
    Integer age;

    public User(String name, String password, Integer uid, Integer age) {
        this.name = name;
        this.password = password;
        this.uid = uid;
        this.age = age;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
