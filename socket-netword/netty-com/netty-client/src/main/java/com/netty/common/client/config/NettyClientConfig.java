package com.netty.common.client.config;


import com.netty.common.client.NettyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyClientConfig {


    @Bean
    public NettyClient nettyClient(){
        NettyClient nettyClient = new NettyClient();
        nettyClient.init();
        nettyClient.connect("127.0.0.1",8512);
        return  nettyClient;
    }
}
