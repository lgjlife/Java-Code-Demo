package com.dubbo.frame.rabbitmq.sender.config.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {

    @Bean
    public  Queue queue(){
        return   new Queue("myqueue");

    }

}
