package com.spring.test.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDemoMapper {

    public List<UserDemo> list(){
        UserDemo userDemo = new UserDemo();
        userDemo.setId(100);
        userDemo.setAge(15);
        userDemo.setName("libai");
        List<UserDemo> userDemos = new ArrayList<>();
        userDemos.add(userDemo);

        return userDemos;
    }

    public List<UserDemo> list(String name){
        UserDemo userDemo = new UserDemo();
        userDemo.setId(100);
        userDemo.setAge(15);
        userDemo.setName(name);
        List<UserDemo> userDemos = new ArrayList<>();
        userDemos.add(userDemo);

        return userDemos;
    }

}
