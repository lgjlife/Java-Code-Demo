package com.mq.kafka.config;

import com.utils.serialization.AbstractSerialize;
import com.utils.serialization.HessianSerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
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
                    log.debug("+++执行平衡消费者之前:onPartitionsRevoked+++");

                    log.debug("topic = {}, partition = {};",value.topic(),value.partition());
                    kafkaConsumer.commitSync();
                });

            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                collection.forEach((value)-> {
                    log.debug("+++执行平衡消费者之后:onPartitionsAssigned+++");

                    log.debug("topic = {}, partition = {};",value.topic(),value.partition());

                    //获取消费偏移量，实现原理是向协调者发送获取请求
                    OffsetAndMetadata offset = kafkaConsumer.committed(value);
                    //设置本地拉取分量，下次拉取消息以这个偏移量为准
                    kafkaConsumer.seek(value, offset.offset());

                });
            }
        });

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(2));
                    for (ConsumerRecord<String, String> record : records){

                       log.info(Thread.currentThread().getName() + "  "+ record.value());

                        log.info("result = :topic:{}; partition:{}; offset:{};",record.topic(),record.partition(),record.offset());

                    }

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
        //自动重置offset　latest　earliest　none
        /**
         earliest
         当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费
         latest
         当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据
         none
         topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
        */
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG ,"latest");
        //反序列化方式
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        return props;
    }


}
