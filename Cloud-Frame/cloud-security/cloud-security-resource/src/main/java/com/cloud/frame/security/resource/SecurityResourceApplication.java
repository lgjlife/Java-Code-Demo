package com.cloud.frame.security.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-10 17:13
 **/


@EnableZuulProxy
@SpringBootApplication
public class SecurityResourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SecurityResourceApplication.class,args);

        //http://localhost:7001/oauth/authorize?client_id=client&response_type=code&redirect_uri=http:localhost:8888/login
//http://localhost:7001/oauth/authorize?username=user1&password=123456&grant_type=password&scope=all&client_id=client&client_secret=secret
    }
}
