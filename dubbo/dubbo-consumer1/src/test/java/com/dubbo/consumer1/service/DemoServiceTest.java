package com.dubbo.consumer1.service;

import com.common.pojo.Person;
import com.dubbo.consumer1.Consumer1Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Consumer1Application.class)
public class DemoServiceTest {

    @Autowired
    DemoService demoService;


    @Test
    public void findPersion() {
        for(int i = 0; i< 20; i++){
            Person person =  demoService.findPersion();
            log.debug("返回值：person = {}",person);

        }

    }
}