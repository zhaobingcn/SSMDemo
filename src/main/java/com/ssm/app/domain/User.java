package com.ssm.app.domain;

/**
 * Created by zhzy on 2017/11/16.
 */
public class User {

    Integer uid;
    String name;
    Integer age;

    public User(Integer uid, String name, Integer age){
        this.uid = uid;
        this.name = name;
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
}
