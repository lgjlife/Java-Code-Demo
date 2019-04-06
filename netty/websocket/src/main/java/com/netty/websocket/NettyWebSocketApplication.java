package com.netty.websocket;


import com.netty.websocket.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableScheduling
@SpringBootApplication
public class NettyWebSocketApplication {

    @Autowired
    public static WebSocketServer webSocketServer;

    public static void main(String args[]) {
        SpringApplication.run(NettyWebSocketApplication.class, args);

        try {
            new WebSocketServer().run(8110);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
