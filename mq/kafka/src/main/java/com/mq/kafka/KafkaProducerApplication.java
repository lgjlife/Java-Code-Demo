package com.mq.kafka;

import com.mq.kafka.config.ProducerClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaProducerApplication.class, args);
        String topic = "topic-test";
        ProducerClientUtil producerClientUtil = ProducerClientUtil.create();

        new Thread(){
            @Override
            public void run() {

                int count =  0;
                while (true){

                    count++;
                    String data = count + " " + new Date().toString();
                   log.info("第"+count+"次,发送数据....." + data);
                   producerClientUtil.sendData(topic,String.valueOf(count),data);
                   try{

                       Thread.sleep(100);
                   }
                   catch(Exception ex){
                       log.error(ex.getMessage());
                   }
               }
            }
        }.start();

    }

}
