package com.dubbo.frame.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication2.class, args);
    }
}
