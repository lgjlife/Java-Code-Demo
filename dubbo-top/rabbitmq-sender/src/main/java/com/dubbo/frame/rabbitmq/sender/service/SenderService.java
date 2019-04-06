package com.dubbo.frame.rabbitmq.sender.service;


import com.dubbo.frame.common.pojo.RabbitUser;
import com.dubbo.frame.rabbitmq.sender.config.rabbitmq.SenderUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    SenderUtil senderUtil;

    public  void sender(){

        RabbitUser user = new RabbitUser("liang",12);

        try{
            amqpTemplate.convertAndSend("myqueue",user);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public  void sender1(){
        senderUtil.sendData1();
    }
}
