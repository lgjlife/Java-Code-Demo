package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipeLineDemoTest {

    @Autowired
    PipeLineDemo demo;

    @Test
    public void pipeLineSet() {
        demo.pipeLineSet();
        demo.pipeLineTest();
    }
}