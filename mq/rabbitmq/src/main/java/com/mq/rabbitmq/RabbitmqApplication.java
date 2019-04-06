package com.mq.rabbitmq;

import com.mq.rabbitmq.config.RabbitmqConsumer;
import com.mq.rabbitmq.config.RabbitmqProducer;
import com.mq.rabbitmq.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);


        RabbitmqProducer producer = RabbitmqProducer.create();
        RabbitmqConsumer consumer = RabbitmqConsumer.create();

        for(int i  = 0; i < 20; i++){

            User user = User.builder().name("用户"+i).age(i).build();
            producer.publish(user);
        }

        try{
            consumer.recdata();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
