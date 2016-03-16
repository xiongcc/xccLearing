package com.example.xiong.xionglearing.xcc.model;

/**
 * Created by Administrator on 2016/2/18.
 */
public class User {
    public String msg;
    public int age;

    public User(String msg, int age) {
        this.msg = msg;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "msg='" + msg + '\'' +
                ", age=" + age +
                '}';
    }

}
