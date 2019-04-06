package com.dubbo.frame.provider1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@ResponseBody
@RequestMapping("/provider")
public class ProviderController {


    @RequestMapping("/test")
    public String  test(){

        log.info("/test");

        return  " I am Test Controller";
    }
}
