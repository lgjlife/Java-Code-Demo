package com.dubbo.frame.rabbitmq.receiver.service;


import com.dubbo.frame.common.pojo.RabbitUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiverService {

    @RabbitListener(queues = "myqueue")
    public  void listener(@Payload  RabbitUser user){

      log.info("receiver the data : " + user);

    }
}
