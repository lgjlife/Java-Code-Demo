package com.dubbo.consumer.service;

import com.common.pojo.Person;
import com.dubbo.consumer.ConsumerApplication;
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
@SpringBootTest(classes = ConsumerApplication.class)
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