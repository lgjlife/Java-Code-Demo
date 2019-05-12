package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import com.mq.rocketmq.producer.MqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class RocketmqApplication {

    public static void main(String[] args) {


        //批量发送数据
      //  batchSender();
        //
        queueSelectSender();

       /* SpringApplication.run(RocketmqApplication.class, args);

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
*/

    }


    public static void batchSender(){

        String topic = "my-topic";

        MqProducer mqProducer  =  new MqProducer();
        mqProducer.createProducer();


        List<String> sendDatas = new ArrayList<>();
        for(int i = 0; i< 10; i++){

            sendDatas.add("消息批量发送:"+i);
        }

        try{
            mqProducer.batchSender(topic,sendDatas);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


        MqConsumer mqConsumer = new MqConsumer();

        try{
            mqConsumer.createPushConsumer();
            mqConsumer.pushData(topic,"*");
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }



    }

    public static void queueSelectSender(){

        String topic = "my-topic";

        MqProducer mqProducer  =  new MqProducer();
        mqProducer.createProducer();


        List<String> sendDatas = new ArrayList<>();
        for(int i = 0; i< 10; i++){

            sendDatas.add("消息批量发送:"+i);
        }

        try{
            mqProducer.queueSelectSender(topic,sendDatas);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


        MqConsumer mqConsumer = new MqConsumer();

        try{
            mqConsumer.createPushConsumer();
            mqConsumer.pushData(topic,"*");
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }



    }


}
