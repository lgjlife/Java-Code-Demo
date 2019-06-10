package com.mybatis.user;

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
public class controller {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/insert")
    public void inset(){
        log.info("/mybatis/insert");
        List<User> users  = new ArrayList<>();

        for(int i = 0;i<3;i++){
            User user = new User();
            user.setName("name:"+new Random().nextInt(100));
            users.add(user);
        }

        userMapper.insertList(users);

        log.info(""+users);

    }

    @RequestMapping("/insert1")
    public void inset1(){
        log.info("/mybatis/insert1");
        User user = new User();
        user.setName("name:"+new Random().nextInt(100));
        userMapper.insert1(user);
        log.info(""+user);

    }

}
