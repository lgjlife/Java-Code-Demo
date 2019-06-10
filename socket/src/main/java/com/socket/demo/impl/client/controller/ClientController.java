package com.socket.demo.impl.client.controller;

import com.socket.demo.impl.client.SocketClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    SocketClient socketClient;

    @RequestMapping("/send")
    public void send() {

        socketClient.send("abcdef");
    }

    @RequestMapping("/rec")
    public void rec() {

        socketClient.rec();
    }
}
