package com.mq.rocketmq.consumer;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class MqConsumer {

    private DefaultMQPushConsumer  pushConsumer ;
    private DefaultMQPullConsumer  pullConsumer ;

    private Map<MessageQueue,Long> offsets = new HashMap<>();


    private AtomicInteger failCount = new AtomicInteger(0);

    private List<Long> times = new ArrayList<>();

    private Long startTime;

    private String group = "my-group1";
    private String serverAddress  = "localhost:9876";


    public MqConsumer() {


    }

    public  void createPushConsumer() throws  Exception{

        pushConsumer = new DefaultMQPushConsumer(group);
        pushConsumer.setNamesrvAddr(serverAddress);
       


    }

    public  void createPushConsumer(String group) throws  Exception{

        pushConsumer = new DefaultMQPushConsumer(group);
        pushConsumer.setNamesrvAddr(serverAddress);
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);

    }



    public void pushData(String topic,String subExpression) throws  Exception{


        pushConsumer.subscribe(topic,subExpression);
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                log.info("消息个数："+msgs.size());
                msgs.forEach((value)->{

                    log.info("接受到的消息=queue:{}-{}",value.getQueueId(),new String(value.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
    }


    public  void createConsumer(String topic){
        pushConsumer = new DefaultMQPushConsumer("my-group1");
        pushConsumer.setNamesrvAddr("localhost:9876");
        startTime=  System.currentTimeMillis();

        try{
            pushConsumer.subscribe(topic,"*");
            pushConsumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    log.info("接受到的消息：{}", msgs);

                    msgs.forEach((value)->{
                        log.info("接受到的实际数据={}",new String(value.getBody()));
                    });
                    long curTimes = System.currentTimeMillis();

                    int count = failCount.incrementAndGet();
                    if(count == 1){
                        startTime = curTimes;
                    }

                    times.add((curTimes-startTime)/1000);
                    log.info("消费次数:"+count);
                    log.info("times = " + times);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            });

            pushConsumer.start();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }




    }


    public  void createPullConsumer(String topic){
        pullConsumer = new DefaultMQPullConsumer("my-group1");
        pullConsumer.setNamesrvAddr("localhost:9876");
        pullConsumer.setMaxReconsumeTimes(5);


        try{

            pullConsumer.start();

            Set<MessageQueue> messageQueues = pullConsumer.fetchSubscribeMessageQueues(topic);

            for(MessageQueue queue: messageQueues){
                offsets.put(queue,pullConsumer.maxOffset(queue));
            }

        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }

    public void pullMessage(String topic){
        System.out.println();
        log.info("开始接收消息...");

        try{


            Set<MessageQueue> messageQueues = pullConsumer.fetchSubscribeMessageQueues(topic);
            messageQueues.forEach((messageQueue)->{

                try{


                    long maxOffset =  pullConsumer.maxOffset(messageQueue);

                    long minOffset =  pullConsumer.minOffset(messageQueue);

                    long ConsumeOffset =  pullConsumer.fetchConsumeOffset(messageQueue,true);

                    log.info("mq = {} ,minOffset = {}",messageQueue.getQueueId(),minOffset);
                    log.info("mq = {} ,maxOffset = {}",messageQueue.getQueueId(),maxOffset);
                    log.info("mq = {} ,ConsumeOffset = {}",messageQueue.getQueueId(),ConsumeOffset);


                }
                catch(Exception ex){
                    log.error(ex.getMessage());
                }

                try{

                    long offset = pullConsumer.fetchConsumeOffset(messageQueue,true);
                    PullResult result =  pullConsumer.pullBlockIfNotFound(messageQueue,"*",getOffset(messageQueue),5);
                    offsets.put(messageQueue,result.getNextBeginOffset());
                    switch (result.getPullStatus()){
                        case FOUND:
                            List<MessageExt> messageExts = result.getMsgFoundList();
                            messageExts.forEach(messageExt -> {
                                log.info("接收数据:"+  new String(messageExt.getBody()));
                            });


                    }

                }
                catch(Exception ex){
                    log.error(ex.getMessage());
                }

            });


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        log.info("接收消息完毕...");
        System.out.println();
    }

    private long getOffset(MessageQueue mq){

        Long offset =  offsets.get(mq);

        if(offset == null){
            try{
                long maxOffset =  pullConsumer.maxOffset(mq);

                long minOffset =  pullConsumer.minOffset(mq);

                long ConsumeOffset =  pullConsumer.fetchConsumeOffset(mq,true);

                log.info("mq = {} ,minOffset = {}",mq.getQueueId(),minOffset);
                log.info("mq = {} ,maxOffset = {}",mq.getQueueId(),maxOffset);
                log.info("mq = {} ,ConsumeOffset = {}",mq.getQueueId(),ConsumeOffset);

                offset = maxOffset;
            }
            catch(Exception ex){
                log.error(ex.getMessage());
            }

        }
/*
       try{

           long maxOffset =  pullConsumer.maxOffset(mq);

           long minOffset =  pullConsumer.minOffset(mq);

           long ConsumeOffset =  pullConsumer.fetchConsumeOffset(mq,true);

           log.info("mq = {} ,maxOffset = {}",mq.getQueueId(),maxOffset);
           log.info("mq = {} ,ConsumeOffset = {}",mq.getQueueId(),ConsumeOffset);
       }
       catch(Exception ex){
           log.error(ex.getMessage());
       }*/
        log.info("mq = {} ,offset = {}",mq.getQueueId(),offset);
        return  offset;
    }



}
