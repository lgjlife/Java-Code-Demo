package com.bean.life.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifeConfiguraation {

    @Bean
    public  Demo demo(){

        System.out.println("BeanLifeConfiguraation  create demo bean");

        return  new Demo();
    }

}
