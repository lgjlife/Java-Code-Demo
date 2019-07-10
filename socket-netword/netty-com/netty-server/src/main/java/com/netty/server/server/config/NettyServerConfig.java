package com.netty.server.server.config;


import com.netty.server.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class NettyServerConfig {


    @Bean
    public NettyServer nettyServer(){

        log.info("NettyServer 创建");

        NettyServer nettyServer = new NettyServer();
        nettyServer.init();
        nettyServer.bind(8512);
        return  nettyServer;
    }


}


