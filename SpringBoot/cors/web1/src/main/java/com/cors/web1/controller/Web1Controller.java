package com.cors.web1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Slf4j
@RestController
public class Web1Controller {

    @CrossOrigin
    @RequestMapping("/hello")
    public String hello(){
        log.info("hello ");
        return "hello," + new Date().toString();
    }
}
