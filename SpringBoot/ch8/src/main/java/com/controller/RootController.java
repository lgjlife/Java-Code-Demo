package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-02 18:12
 **/

@RestController
public class RootController {

    @RequestMapping("/")
    public  String root(){

        return  "RootController--root";
    }
}
