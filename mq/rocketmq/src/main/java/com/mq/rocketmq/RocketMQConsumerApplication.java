package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RocketMQConsumerApplication {

    public static void main(String args[]){

        SpringApplication.run(RocketMQConsumerApplication.class,args);

        String topic = "topic1";

        String group = "consumer-group";

        new Thread(){

            @Override
            public void run() {
                MqConsumer mqConsumer = new MqConsumer();
                try{

                    if(true){
                        mqConsumer.createPushConsumer(group);
                        mqConsumer.pushData(topic,"*");
                    }

                    else {
                        mqConsumer.createPullConsumer(topic);
                        while (true){
                            mqConsumer.pullMessage(topic);
                        }
                    }



                }
                catch(Exception ex){
                    log.error(ex.getMessage());
                }
            }
        }.start();

        /*new Thread(){

            @Override
            public void run() {
                MqConsumer mqConsumer = new MqConsumer();
                try{
                    mqConsumer.createPushConsumer(group);

                    mqConsumer.pushData(topic,"*");
                }
                catch(Exception ex){
                    log.error(ex.getMessage());
                }
            }
        }.start();*/



    }

}
