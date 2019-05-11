package com.mq.kafka.config;

import com.mq.kafka.count.KafkaCountUtil;
import com.utils.serialization.AbstractSerialize;
import com.utils.serialization.HessianSerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class ConsumerClientUtil {


    private AtomicInteger  recCount = new AtomicInteger(0);
    private KafkaConsumer kafkaConsumer;
    private static String BROKER_LISTS = "localhost:9092,localhost:9093";
    private AbstractSerialize serialize = HessianSerializeUtil.getSingleton();


   /* public static void main(String args[]){
        ProducerClientUtil producerClientUtil = ProducerClientUtil.create();
        ConsumerClientUtil consumerClientUtil = ConsumerClientUtil.create();

        String topic = "topic-test";

        consumerClientUtil.recData(topic);

        new Thread(){
            @Override
            public void run() {
                while (true)
                {

                    System.out.println("发送数据.....");
                    int  data = new Random().nextInt(100);
                    producerClientUtil.sendData(topic,String.valueOf(data),"data - " + data);
                    try{
                        Thread.sleep(300);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }.start();
    }*/

    public static ConsumerClientUtil  create(ConsumerCfg cfg){

        ConsumerClientUtil consumerClientUtil = new ConsumerClientUtil();
        KafkaConsumer  kafkaConsumer = new KafkaConsumer(initConfig(cfg));
        consumerClientUtil.kafkaConsumer = kafkaConsumer;
        return consumerClientUtil;
    }



    public void   recData(String TOPIC){
        kafkaConsumer.subscribe(Arrays.asList(TOPIC), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {

                collection.forEach((value)-> {
                    System.out.println("+++++++++++++");
                    System.out.println("onPartitionsRevoked : " + value );


                });

            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                collection.forEach((value)-> {
                    System.out.println("+++++++++++++");
                    System.out.println("onPartitionsAssigned : " + value );

                });
            }
        });

        new Thread(){
            @Override
            public void run() {
                while (true) {
                   // System.out.println("消费者拉取数据");
                    ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                    int recordsCount =0;

                    for (ConsumerRecord<String, String> record : records){
                        //System.out.printf("offset = %d, key = %s, value = %s",record.offset(), record.key(), record.value());
                        recordsCount++;
                        int count = KafkaCountUtil.incAndGetRecCount();
                      //  User user = record.value();
                        log.info("records " + records);

                        log.info(Thread.currentThread().getName() + "  "+  count + ",接收到的数据：" + record.value());


                        //User user = record.value();
                      //  System.out.println();
                    }
                    if(recordsCount !=  0)
                        log.info("recordsCount = " + recordsCount);
                }
            }
        }.start();


    }


    private static  Properties initConfig(ConsumerCfg cfg ){

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LISTS);
        //每个消费者分配独立的组号
        props.put(ConsumerConfig.GROUP_ID_CONFIG, cfg.getGroupId());
        //如果value合法，则自动提交偏移量
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put( ConsumerConfig.MAX_POLL_RECORDS_CONFIG,"5");
        //设置多久一次更新被消费消息的偏移量
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10000");
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        //自动重置offset
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG ,"earliest");
        //反序列化方式
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        return props;
    }


}
