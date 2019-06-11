package com.mybatis.user.controller;

import com.mybatis.user.dao.mapper.UserMapper;
import com.mybatis.user.dao.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/mybatis")
public class Controller {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/insert")
    public void inset(){
        log.info("/mybatis/insert");

        int max = 10;

        for(int count = 0;count < 1;count++){
            List<User> users  = new ArrayList<>();

            for(int i = 0;i<max;i++){
                User user = new User();
                user.setActualName("name:"+new Random().nextInt(10));
                user.setAge(new Byte(new Random().nextInt(10)+""));
                user.setLoginPassword("Password:"+new Random().nextInt(1000000));
                users.add(user);
            }
            userMapper.insertList(users);
            log.info("执行次数:"+count);

        }


    }

    @RequestMapping("/insert1")
    public void inset1(){
        log.info("/mybatis/insert1");
        User user = new User();
        user.setActualName("name:"+new Random().nextInt(100));
        userMapper.insert1(user);
        log.info(""+user);

    }

    @RequestMapping("/select")
    public void select(){
        log.info("/mybatis/select");
        List<User> users =  userMapper.select(1L,"name:98");
        log.info(""+users);

    }


}
