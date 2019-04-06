package com.controller;


import com.dao.model.OsUser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/all")
    public List<OsUser> getUser(){

        System.out.println("访问UserController a");
        List<OsUser> user = userService.getAll();
        return user;

    }
}
