package com.cloud.frame.security.oauth2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 23:25
 **/
@RestController
public class TestEndpoints {

    private static final Logger log = LoggerFactory.getLogger(TestEndpoints.class);

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "order id : " + id;
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable String id) {

        log.info("访问 /buy");
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "buy id : " + id;
    }



}

