package com.spring.test.controller;

import com.spring.test.dao.UserDemo;
import com.spring.test.service.UserDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserDemoController {


    @Autowired
    private UserDemoService userDemoService;

    @GetMapping("/list")
    public List<UserDemo> list(){

        log.info("get /user/list");
        return  userDemoService.list();

    }


}
