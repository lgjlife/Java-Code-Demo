package com.netty.nettysocket.controller;


import com.netty.nettysocket.client.NettyClient;
import com.netty.nettysocket.message.Header;
import com.netty.nettysocket.message.NettyMessage;
import com.netty.nettysocket.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/socket")
public class SocketController {

    @Autowired
    NettyClient nettyClient;

    @RequestMapping("/send")
    public  void send(){

        nettyClient.send("客户端发送过来的数据");

    }

    @RequestMapping("/send/obj")
    public  void sendObject(){


        nettyClient.sendObject(buildNettyMessage());

    }


    private NettyMessage buildNettyMessage(){

        NettyMessage nettyMessage = new NettyMessage();
        Header header = new Header();
        header.setType((byte)1);
        header.setSessionID(1001);
        header.setCrcCode(123);
        header.setLength(0);
        nettyMessage.setHeader(header);

        User user = new User();
        user.setName("Client");
        user.setAge(18);

        nettyMessage.setBody(user);
        return nettyMessage;
    }

}
