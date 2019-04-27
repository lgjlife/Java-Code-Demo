package com.springboot.transaction.controller;


import com.springboot.transaction.dao.User;
import com.springboot.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/query")
    public List<User> query(){

        List<User> users = userService.query();

        return  users;
    }
    @PostMapping("/insert")
    public void insert(){

        userService.insert();
    }
}
