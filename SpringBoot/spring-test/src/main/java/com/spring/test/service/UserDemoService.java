package com.spring.test.service;


import com.spring.test.dao.UserDemo;
import com.spring.test.dao.UserDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDemoService {

    @Autowired
    private  UserDemoMapper userDemoMapper;


    public List<UserDemo> list(){

        return  userDemoMapper.list();

    }

    public List<UserDemo> list(String name){

        return  userDemoMapper.list( name);

    }


}
