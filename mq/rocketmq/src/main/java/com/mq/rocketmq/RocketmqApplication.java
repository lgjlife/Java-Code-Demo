package com.mq.rocketmq;

import com.mq.rocketmq.consumer.MqConsumer;
import com.mq.rocketmq.producer.MqProducer;
import com.mq.rocketmq.producer.TransactionDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class RocketmqApplication {

    public static void main(String[] args) {


        //批量发送数据
      batchSender();
        //  normalSender();
        //
       // queueSelectSender();
        //     transactionSender();
    //  SpringApplication.run(RocketmqApplication.class, args);

    }

    public static void normalSender(){

        String topic = "my-topic";

        MqProducer mqProducer  =  new MqProducer();
        mqProducer.createProducer();


        List<String> sendDatas = new ArrayList<>();


        try{


            for(int i = 0; i< 10; i++){

                mqProducer.asyncSendData(topic,"消息异步发送+" + i);
            }

            new Thread(){

                @Override
                public void run() {
                    while (true){


                        mqProducer.asyncSendData(topic,"消息异步发送+" + 1);
                        mqProducer.asyncSendData(topic,"消息异步发送+" + 1);
                        mqProducer.asyncSendData(topic,"消息异步发送+" + 1);
                        try{

                            Thread.sleep(2000);
                        }
                        catch(Exception ex){
                            log.error(ex.getMessage());
                        }
                    }

                }
            }.start();


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

    public static void batchSender(){

        String topic = "my-topic";

        MqProducer mqProducer  =  new MqProducer();
        mqProducer.createProducer();


        List<String> sendDatas = new ArrayList<>();
        for(int i = 0; i< 10; i++){

            sendDatas.add("消息批量发送:"+i + "   "+new Date().toString());
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


       /* MqConsumer mqConsumer = new MqConsumer();

        try{
            mqConsumer.createPushConsumer();
            mqConsumer.pushData(topic,"*");
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }*/
    }

    /**
     *功能描述
     * @author lgj
     * @Description  事务消息操作
     * @date 5/12/19
     * @param:
     * @return:
     *
    */
    public static void transactionSender(){

        String topic = "my-topic";

        TransactionDemo transactionDemo = new TransactionDemo();

        try{
            transactionDemo.createProducer();
            transactionDemo.createPushConsumer();

            transactionDemo.pushData(topic,"*");

        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

        List<String> sendDatas = new ArrayList<>();
        for(int i = 0; i< 1; i++){

            sendDatas.add(new Date().toString() + " 事务消息发送:"+i);
        }

        try{
            transactionDemo.TransactionSend(topic,sendDatas);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }
}
