package com.mq.kafka;

import com.mq.kafka.config.ConsumerCfg;
import com.mq.kafka.config.ConsumerClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class KafkaConsumer1Application {

    public static void main(String[] args) {
  SpringApplication.run(KafkaProducerApplication.class, args);

        ConsumerCfg consumerCfg = ConsumerCfg.builder().groupId("group-a").build();
        ConsumerClientUtil consumerClientUtil = ConsumerClientUtil.create(consumerCfg);
        String topic = "topic-test";

        log.info("消费者消费数据");
        consumerClientUtil.recData(topic);
       // consumerClientUtil1.recData(topic);
    }

}
