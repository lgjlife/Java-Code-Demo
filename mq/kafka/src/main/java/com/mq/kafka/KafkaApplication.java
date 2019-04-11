package com.mq.kafka;

import com.mq.kafka.config.ConsumerCfg;
import com.mq.kafka.config.ConsumerClientUtil;
import com.mq.kafka.config.ProducerClientUtil;
import com.mq.kafka.count.KafkaCountUtil;
import com.mq.kafka.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@Slf4j
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {





        SpringApplication.run(KafkaApplication.class, args);

        ProducerClientUtil producerClientUtil = ProducerClientUtil.create();

        ConsumerCfg consumerCfg = ConsumerCfg.builder().groupId("group-a").build();
        ConsumerClientUtil consumerClientUtil = ConsumerClientUtil.create(consumerCfg);
        ConsumerCfg consumerCfg1 = ConsumerCfg.builder().groupId("group-a1").build();
        ConsumerClientUtil consumerClientUtil1 = ConsumerClientUtil.create(consumerCfg1);
        String topic = "create-topic-1";



        new Thread(){
            @Override
            public void run() {

                int sendCount = 0;

                for(int i = 0 ; i < 20 ;i++)
                {
                    sendCount = KafkaCountUtil.incAndGetSendCount();
                    log.info("第"+sendCount+"次,发送数据.....");
                    int  data = new Random() .nextInt(100);

                    User user = new User();
                    user.setAge(15);
                    user.setName("lingxa");

                    producerClientUtil.sendData(topic,String.valueOf(i),user);

                  /*  try{
                        Thread.sleep(300);
                    }
                    catch(Exception ex){

                        ex.printStackTrace();
                    }*/

                }
            }
        }.start();

        //
        System.out.println("消费者消费数据");
        consumerClientUtil.recData(topic);
       // consumerClientUtil1.recData(topic);
    }

}
