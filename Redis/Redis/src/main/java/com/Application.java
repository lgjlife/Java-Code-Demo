package com;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.dao.support.DaoSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

       log.info("执行主线程");
        SpringApplication.run(Application.class, args);
        //SpringFactoriesLoader
    }
}