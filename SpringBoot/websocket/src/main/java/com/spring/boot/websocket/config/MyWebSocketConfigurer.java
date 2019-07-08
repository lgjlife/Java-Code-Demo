package com.spring.boot.websocket.config;

import com.spring.boot.websocket.websocket.MySocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Slf4j
@Configuration
@EnableWebSocket
public class MyWebSocketConfigurer implements WebSocketConfigurer {

    @Autowired
    MySocketHandler socketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        log.info("registerWebSocketHandlers ...");
        registry.addHandler(socketHandler,"/").setAllowedOrigins("*");

    }
}
