package com.dubbo.provider3;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class Provider3Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider3Application.class, args);
    }

}
