package com.netty.server.server.controller;


import com.netty.server.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/netty/server")
public class NettyController {

    @Autowired
    private NettyServer nettyServer;


    @RequestMapping("/close")
    public void close(){
        nettyServer.close(8512);
    }
}
