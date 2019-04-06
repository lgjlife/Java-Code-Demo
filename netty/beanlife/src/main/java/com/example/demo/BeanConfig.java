package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

   /* @Bean(initMethod = "init",destroyMethod = "destory")
    public BeanDemo demo(){

        return  new BeanDemo();
    }*/


    @Bean(initMethod = "init",destroyMethod = "destory")
    public BeanLife BeanLife(){

        return  new BeanLife();
    }
}
