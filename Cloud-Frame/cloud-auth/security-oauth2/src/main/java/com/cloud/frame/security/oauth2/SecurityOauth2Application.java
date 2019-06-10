package com.cloud.frame.security.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-16 16:34
 **/

@MapperScan(basePackages = "com.cloud.frame.security.aserver.dao.mapper")
@EnableEurekaClient
@SpringBootApplication
public class SecurityOauth2Application {
    public static void main(String[] args) {

        SpringApplication.run(SecurityOauth2Application.class,args);
    }
}
