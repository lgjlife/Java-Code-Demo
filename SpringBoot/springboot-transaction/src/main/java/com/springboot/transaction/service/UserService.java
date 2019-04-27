package com.springboot.transaction.service;


import com.springboot.transaction.dao.User;
import com.springboot.transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public  List<User>  query(){

        List<User> users = userMapper.selectAll();

        return  users;
    }

    public void insert(){
        User user = new User();
        user.setName("libai");

        userMapper.insert(user);
    }
}
