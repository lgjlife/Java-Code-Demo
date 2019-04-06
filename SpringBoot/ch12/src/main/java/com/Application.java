package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(basePackages = {"com.dao.mapper","com.ch12.dao.mapper"})
@SpringBootApplication
@ComponentScan
 public class Application extends SpringBootServletInitializer {


        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
                return application.sources(Application.class);
                }

        public static void main(String[] args) {
           // log.info("执行主线程");
                SpringApplication.run(Application.class, args);
        }
}