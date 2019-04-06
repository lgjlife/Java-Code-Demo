package com.mq.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.utils.serialization.AbstractSerialize;
import com.utils.serialization.ProtostuffSerializeUtil;
import lombok.Data;


/**
 *功能描述
 * @author lgj
 * @Description  rabbitmq 生产者
 * @date 3/22/19
*/
@Data
public class RabbitmqProducer {

    private static  String EXCHANGE_NAME = "my-exchange";
    private static  String QUEUE_NAME = "my-queue";
    private static  String ROUTING_KEY = "my-routing";
    private static  String HOST = "localhost";
    private static  int PORT = 5672;
    private AbstractSerialize  serialize = new ProtostuffSerializeUtil();

    private Connection connection;

    private RabbitmqProducer(){

    }


    public static  RabbitmqProducer create(){
        RabbitmqProducer producer = new RabbitmqProducer();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("lgj");
        factory.setPassword("lgj");
        factory.setHost(HOST);
        factory.setPort(PORT);


        try{
            Connection connection = factory.newConnection();
            producer.setConnection(connection);

            return producer;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return  null;

    }


    public void  publish(Object msg){
        Channel channel = null;

        try{
            channel = connection.createChannel();
            //channel.exchangeDeclare(EXCHANGE_NAME,ExchangeType.DIRECT_TYPE,true,false,null);
            // channel.queueDeclare(QUEUE_NAME,true,false,false,null);
            //绑定queue和exchange
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
            //根据路由键发布消息
            byte[] sendData = serialize.serialize(msg);
            channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,sendData);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try{
                channel.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
