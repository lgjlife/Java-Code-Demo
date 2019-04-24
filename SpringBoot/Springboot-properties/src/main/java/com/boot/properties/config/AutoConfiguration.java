package com.boot.properties.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@EnableConfigurationProperties(AllConfigurationProperties.class)
@Configuration
public class AutoConfiguration {

    @Autowired
    AllConfigurationProperties properties;

    @PostConstruct
    public void  init(){

        System.out.println("properties = " + properties);

    }

}
