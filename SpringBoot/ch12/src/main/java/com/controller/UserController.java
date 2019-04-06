package com.controller;


import com.dao.model.OsUser;
import com.service.UserService;
import com.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    User user = new User();
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/all")
    public List<OsUser> getUser(){

        System.out.println("访问UserController getUser");

        user.name();

        List<OsUser> users = null;
        if(userService == null){
            System.out.println("userService is null");
        }
        else{
            System.out.println("执行userService.getAll()");
            users = userService.getAll();
        }

        System.out.println("执行userService.getAll() 结束");

        if(users == null){
            log.info("user is null");
        }
        else{
            System.out.println("get user success " + users.size());

            for(OsUser u: users){
                System.out.println(u.getPhoneNum());
            }
        }
        OsUser user = new OsUser();
        user.setActualName("sadsd");
        users.add(user);
        return users;

    }

    @RequestMapping("/test")
    public void test(){

        System.out.println("访问UserController  test");

    }
}

class User{

    public void name(){
        System.out.println("user--name()");
    }
}