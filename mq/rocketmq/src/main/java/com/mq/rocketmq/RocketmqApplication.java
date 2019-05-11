package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import com.mq.rocketmq.producer.MqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqApplication.class, args);

        String topic = "my-topic";

        MqConsumer mqConsumer =  new MqConsumer();
        mqConsumer.createPullConsumer(topic);


        MqProducer mqProducer = new MqProducer();
        mqProducer.createProducer();
        new Thread(){
            @Override
            public void run() {
                int num = 0;
                while (true){
                    try{

                        mqProducer.syncSendData("同步数据：" + num++ );
                        Thread.sleep(2000);
                    }
                    catch(Exception ex){
                        log.error(ex.getMessage());
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                int num = 0;
                while (true){
                    try{
                        mqConsumer.pullMessage(topic);
                       // Thread.sleep(2000);
                    }
                    catch(Exception ex){
                        log.error(ex.getMessage());
                    }
                }
            }
        }.start();

       /* try{
            Set<MessageQueue> messageQueues = mqConsumer.getConsumer().fetchSubscribeMessageQueues(topic);

            log.info("messageQueues.size = "+messageQueues.size());
            log.info("messageQueues = " + messageQueues);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }*/
        // mqProducer.syncSendData("同步数据：123456789");
        //异步方式发送
     //   mqProducer.asyncSendData("异步数据：123456789");

        //单向方式发送
        //mqProducer.asyncSendData("单向数据：123456789");


        //
      //  mqProducer.scheduledSendData("定时数据：123456789");
    }

}
