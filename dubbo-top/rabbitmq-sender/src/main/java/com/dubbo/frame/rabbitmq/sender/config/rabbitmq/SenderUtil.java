package com.dubbo.frame.rabbitmq.sender.config.rabbitmq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class SenderUtil {

    private  ConnectionFactory  factory;
    private Connection connection;

    private   void createFactory(){

        factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setPassword("guest");
        factory.setUsername("guest");
    }


    public Connection getConnection() {

        if(connection == null){
            synchronized (SenderUtil.class){
                if(connection == null){
                    createFactory();
                    try {
                        connection = factory.newConnection();
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }

                }
                return  connection;
            }
        }
        else{
            return  connection;
        }
    }


    public void sendData(){

        String bindKey = "bindkey";
        String routKey = "routKey";
        String exchangeName1 = "ex11";
        String exchangeName2 = "ex21";

        String queueName1 = "queue1";
        String queueName2 = "queue2";

        Connection connection = getConnection();

        try{
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName1,ExchangeType.topic.name(),true,false,null);
            channel.queueDeclare(queueName1,true,false,false,null);
            channel.exchangeDeclare(exchangeName2,ExchangeType.direct.name(),true,false,null);
            channel.queueDeclare(queueName2,true,false,false,null);

            channel.queueBind(queueName1,exchangeName1,bindKey);
            channel.queueBind(queueName2,exchangeName1,bindKey);

            channel.queueBind(queueName2,exchangeName2,bindKey);
            channel.queueBind(queueName2,exchangeName2,bindKey);
            String message = "sadsadas";
            channel.basicPublish(exchangeName1,routKey, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());


        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * 发送失败处理
     */
    public void sendData1(){

        String bindKey = "bindkey";
        String routKey = "routKey";
        String exchangeName1 = "ex111";
        String queueName1 = "queue111";


        Connection connection = getConnection();

        try{
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName1,ExchangeType.direct.name(),true,false,null);
            channel.queueDeclare(queueName1,true,false,false,null);
            channel.queueBind(queueName1,exchangeName1,bindKey);
            String message = "sadsadas";
            channel.basicPublish(exchangeName1,routKey,true, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            channel.addReturnListener(new ReturnListener() {
                @Override
                public void handleReturn(int replyCode, String replyText, String exchange,
                                         String routingKey, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    log.info("replyCode = " + replyCode);
                    log.info("replyText = " + replyText);
                    log.info("exchange = " + exchange);
                    log.info("routingKey = " + routingKey);

                    log.info("body = " + new String(body));

                }
            });

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
