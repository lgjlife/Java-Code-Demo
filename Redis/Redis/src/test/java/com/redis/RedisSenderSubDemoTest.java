package com.redis;

import com.redis.pubsub.PubSubDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSenderSubDemoTest {

    @Autowired
    PubSubDemo pubSub;

    @Test
    public void pubSub() {
        pubSub.pubSub();
    }
}