package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class RocketMQConsumer1Application {

    public static void main(String args[]){

        SpringApplication.run(RocketMQConsumer1Application.class,args);

        String topic = "topic1";

        String group = "consumer-group";

        MqConsumer mqConsumer = new MqConsumer();
        try{
            /*mqConsumer.createPushConsumer(group);

            mqConsumer.pushData(topic,"*");*/

            mqConsumer.createPullConsumer(topic);
            while (true){
                mqConsumer.pullMessage(topic);
            }
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

    }

}
