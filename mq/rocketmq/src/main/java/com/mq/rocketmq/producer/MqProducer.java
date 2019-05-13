package com.mq.rocketmq.producer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *功能描述
 * @author lgj
 * @Description   rocket 消息生产者
 * @date 3/18/19
*/
@Slf4j
public class MqProducer {
    private  DefaultMQProducer  producer;

    private String group = "my-group";
    private String addr = "localhost:9876";

    private String topic = "my-topic";
    private String tags = "my-tag";


    /**
     *功能描述 
     * @author lgj
     * @Description  创建 producer
     * @date 3/18/19
     * @param: 
     * @return: 
     *
    */
    public  void createProducer(){

        producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(addr);

        //设置自动创建topic的key值
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");

        try{
            producer.start();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }



    /**
     *功能描述
     * @author lgj
     * @Description  同步方式发送
     * @date 3/18/19
     * @param:
     * @return:
     *
    */
    public SendResult syncSendData(String send){
        Message msg = new Message(topic,tags,send.getBytes());
        SendResult sendResult = null;
        try{

           // log.debug("同步方式发送数据....");
            sendResult = producer.send(msg);
           // log.debug("同步方式发送数据结束！");
            log.info("SyncProducer result = {}-{}",sendResult.getMessageQueue().getQueueId(),sendResult.getQueueOffset());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return  sendResult;
    }

    /**
     *功能描述
     * @author lgj
     * @Description  异步方式发送
     * @date 3/18/19
     * @param:
     * @return:
     *
     */
    public SendResult asyncSendData(String topic,String send){
        Message msg = new Message(topic,tags,send.getBytes());

        SendResult result = null;
        try{

           // log.debug("异步方式发送数据....");
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                  //  log.debug("异步方式发送数据结束！");
                  //  log.info("SyncProducer result = {}-{}",sendResult.getMessageQueue().getQueueId(),sendResult.getQueueOffset());
                }

                @Override
                public void onException(Throwable throwable) {
                    log.debug("异步方式发送数据失败！,异常={}",throwable.getMessage());

                }
            });


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return  result;
    }




    /**
     *功能描述
     * @author lgj
     * @Description  oneway 单向发送 ，无反馈
     * @date 3/18/19
     * @param:
     * @return:
     *
     */
    public SendResult onewaySendData(String send){
        Message msg = new Message(topic,tags,send.getBytes());
        SendResult result = null;
        try{

            log.debug("单向方式发送数据....");
            producer.sendOneway(msg);
            log.debug("单向方式发送数据....");


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return  result;
    }



    /**
     *功能描述
     * @author lgj
     * @Description   定时发送
     * @date 3/18/19
     * @param:
     * @return:
     *
     */
    public SendResult scheduledSendData(String send){
        String  sendData = (send + " -- "+ new Random().nextInt(100));
        Message msg = new Message(topic,tags,sendData.getBytes());

        //1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
        // 1 -- 1s  ,2--5s ,3--10s
        // 可以在brocker配置
        // messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        msg.setDelayTimeLevel(5);
        SendResult result = null;
        try{

            log.debug("定时方式发送数据....{}",sendData);
            producer.send(msg);
            log.debug("定时方式发送数据....");

            new  Thread(){
                @Override
                public void run() {

                    int count = 0;

                    while (true){
                        try{
                            log.debug("已经发送{}s",(count++));
                            Thread.sleep(1000);

                        }
                        catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }.start();


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return  result;
    }


    /**
     *功能描述
     * @author lgj
     * @Description  关闭生产者
     * @date 3/18/19
     * @param:
     * @return:
     *
    */
    public  void shutdown(){
        producer.shutdown();
    }


    /**
     *功能描述
     * @author lgj
     * @Description 消息批量发送
     * @date 5/12/19
    */
    public void batchSender(String topic,List<String> sendDatas) throws Exception{

        List<Message> messages =  new ArrayList<>();

        for(String data:sendDatas){
            messages.add(new Message(topic,data.getBytes()));
        }

        producer.send(messages);
    }

    /**
     *功能描述
     * @author lgj
     * @Description 消息发送队列选择
     * @date 5/12/19
    */
    public void queueSelectSender(String topic,List<String> sendDatas) throws Exception{

        List<Message> messages =  new ArrayList<>();

        for(String data:sendDatas){
            messages.add(new Message(topic,data.getBytes()));
        }

        for(int i = 0; i< sendDatas.size(); i++){
            producer.send(messages.get(i),new MessageQueueSelector(){
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {

                    log.info("o = " + o);
                    return list.get(3);
                }
            },i+10);
        }


    }
}
