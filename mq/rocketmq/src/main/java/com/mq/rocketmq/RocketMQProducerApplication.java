package com.mq.rocketmq;


import com.mq.rocketmq.producer.MqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class RocketMQProducerApplication {

    public static void main(String args[]){

        SpringApplication.run(RocketMQProducerApplication.class,args);

        new Thread(){

            @Override
            public void run() {

                String group = "group1";
                String topic = "topic1";

                new Thread(){

                }.start();

                MqProducer mqProducer =  new MqProducer();

                mqProducer.createProducer(group);




                int count = 0;
                while (true){
                    try{

                        count++;
                        String data = "[ "+ count + "------"+ new Date().toString() + "]";
                        log.info("发送的数据:" + data);
                        mqProducer.asyncSendData(topic,data);
                        Thread.sleep(1000);

                    }
                    catch(Exception ex){
                        log.error(ex.getMessage());
                    }


                }


            }
        }.start();
    }
}
