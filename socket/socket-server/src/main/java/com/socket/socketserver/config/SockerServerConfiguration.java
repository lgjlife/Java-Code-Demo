package com.socket.socketserver.config;


import com.socket.socketserver.SocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SockerServerConfiguration {


    @Bean
    public SocketServer socketServer() {
        log.info("SockerServerConfiguration...................");
        SocketServer socketServer = new SocketServer();
        socketServer.bind(7788);
        socketServer.rec();
        return socketServer;
    }
}
