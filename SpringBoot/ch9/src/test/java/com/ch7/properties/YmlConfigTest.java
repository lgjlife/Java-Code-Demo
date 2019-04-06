package com.ch7.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
public class YmlConfigTest {

    @Autowired
    YmlConfig ymlConfig;
    @Autowired
    YmlConfig1 ymlConfig1;

    @Test
    public void printYml(){
        System.out.println(ymlConfig.toString());
        System.out.println(ymlConfig1.toString());
    }
}