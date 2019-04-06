package com.dubbo.frame.rabbitmq.sender.controller;


import com.dubbo.frame.rabbitmq.sender.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/amqp")
public class AmqpController {

    @Autowired
    private  SenderService senderService;

    @GetMapping
    public  String send(){

        log.info("/amqp");
        senderService.sender1();
        return  "send.......";
    }
}
