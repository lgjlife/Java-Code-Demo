package com.bean.life.entity;


import org.springframework.context.annotation.Bean;

//@Configuration
public class BeanLifeConfiguration {

    @Bean
    public  Demo demo(){

        System.out.println("BeanLifeConfiguraation  create demo bean");

        return  new Demo();
    }

}
