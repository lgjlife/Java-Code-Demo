package com.springboot.transaction.service;

import com.springboot.transaction.dao.User;

import java.util.Random;

public class UserBuilder {

    public static User build(){

        User user = new User();
        String name = "name:"+new Random().nextInt(10000);
        user.setName(name);
        return  user;

    }
}
