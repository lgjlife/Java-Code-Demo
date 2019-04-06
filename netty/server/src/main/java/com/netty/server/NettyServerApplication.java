package com.netty.server;


import com.netty.server.service.TimeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NettyServerApplication {

    @Autowired
    public static TimeServer timeServer;

    public static void main(String args[]) {
        SpringApplication.run(NettyServerApplication.class, args);

        try {
            new TimeServer().bind(8112);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
