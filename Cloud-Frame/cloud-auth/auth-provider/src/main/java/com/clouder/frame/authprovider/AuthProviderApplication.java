package com.clouder.frame.authprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthProviderApplication.class, args);
    }
}
