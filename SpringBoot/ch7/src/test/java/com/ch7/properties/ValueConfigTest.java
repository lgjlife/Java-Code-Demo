package com.ch7.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
public class ValueConfigTest {

    @Autowired
    ValueConfig valueConfig;// = new ValueConfig();

    @Test
    public void printTest(){

        System.out.println("使用@value 方式");
        System.out.println(valueConfig.toString());
    }


}