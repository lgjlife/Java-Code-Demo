package com.socket.socketserver.controller;


import com.socket.socketserver.SocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    SocketServer socketServer;

    @RequestMapping("/send")
    public void send() {

        socketServer.send("123456");
    }

    @RequestMapping("/rec")
    public void rec() {

        socketServer.rec();
    }

}
