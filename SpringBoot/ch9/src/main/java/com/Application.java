package com;


import org.com.ch.TestClass;
import org.com.zh.ZhClass;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(basePackages = "com.dao.mapper")
@SpringBootApplication
@ComponentScan("org.com.ch")
 public class Application extends SpringBootServletInitializer {

        @Autowired
        private TestClass testClass;

        @Autowired
        private ZhClass zhClass;
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
                return application.sources(Application.class);
                }

        public static void main(String[] args) {
           // log.info("执行主线程");
                SpringApplication.run(Application.class, args);
        }
}