package com.dubbo.frame.provider1;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication1.class, args);
    }
}
