package com.dubbo.frame.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.frame.common.service.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
public class RemoteUserController {




    AtomicInteger count = new AtomicInteger(0);

    //random   RoundRobin
    @Reference(version = "1.0.0",check = true, loadbalance = "random" ,cluster = "broadcast")
    private RemoteUserService remoteUserService;



    @RequestMapping(value="/dubbo/say/{name}")
    public String sayHello(@PathVariable("name") String name){


        int c = count.incrementAndGet();
        log.info( "调用次数 = " + c);
        String result=remoteUserService.sayHello( c+"");
        log.info("result = " + result);
        return result;
    }

    @RequestMapping("test")
    @Reference(url = "http://localhost:8180/provider")
    public  String provider(){
        return "test";
    }
}


