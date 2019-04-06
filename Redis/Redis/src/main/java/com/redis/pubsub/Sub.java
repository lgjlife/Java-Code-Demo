package com.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-29 16:48
 **/
@Component
public class Sub implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger("MessageListener");
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    RedisSerializer<MyMessage> redisSerializer;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        redisSerializer = (RedisSerializer<MyMessage>)redisTemplate.getValueSerializer();
        MyMessage message1 = redisSerializer.deserialize(message.getBody());

        log.info("The message channel is " + message.getChannel());
        log.info("The message data is " + message1.toString());
    }
}
