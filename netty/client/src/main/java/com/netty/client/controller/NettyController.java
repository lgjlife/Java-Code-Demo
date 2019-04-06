package com.netty.client.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/netty")
public class NettyController {

    @RequestMapping("/send")
    public String send() {

        return "";
    }
}
