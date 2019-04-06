package com.netty.client;


import com.netty.client.service.TimeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyClientApplication {

    @Autowired
    private static TimeClient timeClient;


    public static void main(String args[]) {

        SpringApplication.run(NettyClientApplication.class, args);

        try {

            new TimeClient().connect(8112, "127.0.0.1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
