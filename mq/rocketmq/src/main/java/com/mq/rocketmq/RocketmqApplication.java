package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import com.mq.rocketmq.producer.MqProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqApplication.class, args);

        new MqConsumer().createConsumer();

        MqProducer mqProducer = new MqProducer();
        mqProducer.createProducer();

      //  BeanFactory

        //同步方式发送
       // mqProducer.syncSendData("同步数据：123456789");
        //异步方式发送
     //   mqProducer.asyncSendData("异步数据：123456789");

        //单向方式发送
        //mqProducer.asyncSendData("单向数据：123456789");


        //
        mqProducer.scheduledSendData("定时数据：123456789");
    }

}
