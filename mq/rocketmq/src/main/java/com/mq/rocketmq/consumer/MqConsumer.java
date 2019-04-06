package com.mq.rocketmq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

@Slf4j
public class MqConsumer {

    private DefaultMQPushConsumer  consumer ;

    public  void createConsumer(){
        consumer = new DefaultMQPushConsumer("my-group1");
        consumer.setNamesrvAddr("localhost:9876");
        try{
            consumer.subscribe("my-topic","*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    log.info("接受到的消息：{}", msgs);

                    msgs.forEach((value)->{
                        log.info("接受到的实际数据={}",new String(value.getBody()));
                    });
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            consumer.start();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }




    }
}
