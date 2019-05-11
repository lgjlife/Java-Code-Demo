package com.boot.properties.importclz;

import com.boot.properties.config.AllConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;



public class NullImpl {

    @Autowired
    AllConfigurationProperties properties;


    @Autowired
    ApplicationContext context;


    @PostConstruct
    public void init(){

        System.out.println("NullImpl context = " + context);
        System.out.println("NullImpl init....");
        System.out.println("NullImpl = " + properties);
    }
}
