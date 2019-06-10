package com.cloud.frame.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-10 17:13
 **/
@ComponentScan(basePackages = {"com.cloud.frame.common","com.cloud.frame.oauth2.aserver"})
@SpringBootApplication
public class Oauth2ServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(Oauth2ServerApplication.class,args);
    }
}
