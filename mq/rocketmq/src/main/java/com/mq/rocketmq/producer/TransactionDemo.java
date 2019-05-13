package com.mq.rocketmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageAccessor;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TransactionDemo {

    private TransactionMQProducer producer;
    private DefaultMQPushConsumer  pushConsumer ;

    private String group = "my-group1";
    private String serverAddress  = "localhost:9876";



    public void createProducer() throws Exception{

        producer = new TransactionMQProducer();
        ExecutorService executorService =  Executors.newFixedThreadPool(10);
        producer.setNamesrvAddr(serverAddress);
        producer.setProducerGroup(group);
        producer.setExecutorService(executorService);
        producer.setTransactionListener(new TransactionListenerImpl());

        producer.start();
    }

    public void  TransactionSend(String topic ,List<String> sendDatas) throws Exception{

        for(String data:sendDatas){
            //MessageConst

            Message message = new Message(topic,data.getBytes());

            MessageAccessor.putProperty(message, MessageConst.PROPERTY_TRANSACTION_CHECK_TIMES,"3");


            TransactionSendResult result = producer.sendMessageInTransaction(message,"asdd");
            log.info("result = " + result);
        }
    }

    public  void createPushConsumer() throws  Exception{

        pushConsumer = new DefaultMQPushConsumer(group);
        pushConsumer.setNamesrvAddr(serverAddress);

    }

    public void pushData(String topic,String subExpression) throws  Exception{


        pushConsumer.subscribe(topic,subExpression);
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                msgs.forEach((value)->{

                    log.info("接受到的消息=queue:{}-{}",value.getQueueId(),new String(value.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
    }



    class TransactionListenerImpl implements TransactionListener {

        private ConcurrentHashMap<String, LocalTransactionState> localTrans = new ConcurrentHashMap<>();

        /**
         *功能描述
         * @author lgj
         * @Description  用于执行本地事务
         * @date 5/12/19
         * @param:
         * @return:
         *
        */
        @Override
        public LocalTransactionState executeLocalTransaction(Message message, Object o) {
            log.info("TransactionListenerImpl　executeLocalTransaction ");

            try{

                Thread.sleep(10000);
            }
            catch(Exception ex){
                log.error(ex.getMessage());
            }
            //执行本地事务
            LocalTransactionState state = LocalTransactionState.UNKNOW;
            localTrans.put(message.getTransactionId(),state);
            return state;
        }

        /**
         *功能描述
         * @author lgj
         * @Description  检查本地事务状态　并响应MQ检查请求
         * @date 5/12/19
         * @param:
         * @return:
         *
        */
        @Override
        public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {



            LocalTransactionState state = localTrans.get(messageExt.getTransactionId());
           // localTrans.remove(messageExt.getTransactionId());
            log.info("TransactionListenerImpl　checkLocalTransaction : " + state);
            if(state != null){
                switch (state){

                    case COMMIT_MESSAGE:
                        return LocalTransactionState.COMMIT_MESSAGE;
                    case ROLLBACK_MESSAGE:
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    case UNKNOW:
                        return LocalTransactionState.UNKNOW;
                }
            }
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }

}
