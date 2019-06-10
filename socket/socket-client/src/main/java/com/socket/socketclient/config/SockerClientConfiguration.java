package com.socket.socketclient.config;


import com.socket.socketclient.SocketClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SockerClientConfiguration {


    @Bean
    public SocketClient socketClient() {
        log.info("SockerClientConfiguration......");
        SocketClient socketClient = new SocketClient();
        socketClient.connect("127.0.0.1", 7788);
        socketClient.rec();
        return socketClient;
    }


}

