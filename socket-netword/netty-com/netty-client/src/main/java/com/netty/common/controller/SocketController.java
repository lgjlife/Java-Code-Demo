package com.netty.common.controller;


import com.netty.common.client.NettyClient;
import com.netty.common.message.Header;
import com.netty.common.message.MessageType;
import com.netty.common.message.NettyMessage;
import com.netty.common.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/socket")
public class SocketController {

    private String  name = "1";

    private int  meaasgeId = 0;

    @Autowired
    NettyClient nettyClient;

    @RequestMapping("/send")
    public  void send(){

        nettyClient.send("客户端发送过来的数据");

    }

    @RequestMapping("/send/obj")
    public  void sendObject(){
        meaasgeId = 0;
        for(int i = 0; i< 1000; i++) {
            try{
                //Thread.sleep(10);
            }
            catch(Exception ex){
                log.error(ex.getMessage());
            }
            nettyClient.sendObject(buildNettyMessage());
        }


    }


    private NettyMessage buildNettyMessage(){

        NettyMessage nettyMessage = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.APP_REQUEST_TYPE.getValue());
        header.setSessionID(meaasgeId++);
        header.setCrcCode(123);
        header.setLength(0);
        nettyMessage.setHeader(header);

        User user = new User();
        name = name + 1;
        user.setName("Client-");
        user.setAge(18);

        nettyMessage.setBody(user);
        return nettyMessage;
    }

    @RequestMapping("/close")
    public void close(){
        nettyClient.close(8512);
    }


}
