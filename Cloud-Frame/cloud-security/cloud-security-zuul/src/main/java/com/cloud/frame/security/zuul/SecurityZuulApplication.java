package com.cloud.frame.security.zuul;

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
public class SecurityZuulApplication {

    public static void main(String[] args) {

        SpringApplication.run(SecurityZuulApplication.class,args);
    }
}
