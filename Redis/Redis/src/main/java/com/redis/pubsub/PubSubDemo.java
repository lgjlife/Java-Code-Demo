package com.redis.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 发布／订阅例程
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-29 11:27
 **/

@Component
public class PubSubDemo {

    @Autowired
    RedisSender redisSender;

    public void  pubSub(){
        redisSender.pubMessage1();
    }
}



