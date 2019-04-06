package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//Spring boot Test自动配置
@SpringBootTest
public class StringsDemoTest {

    @Autowired
    StringsDemo demo;// = new StringsDemo();

    @Test
    public void set() {
        demo.getAndset();

    }

    @Test
    public void multiSet() {
        demo.multiSet();

    }

}