package com.mq.kafka.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;

public class AdminClientUtil {

    private static final String NEW_TOPIC = "topic-test2";
    private static final String brokerUrl = "localhost:9092";
    private AdminClient client;

    public static void main(String args[]){
        AdminClientUtil clientUtil = AdminClientUtil.create();

        clientUtil.createTopic();
        clientUtil.listTopic();

    }

    public static  AdminClientUtil create(){

        AdminClientUtil clientUtil = new AdminClientUtil();
        Properties props  = new Properties();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,brokerUrl);
        clientUtil.client =  AdminClient.create(props);
        return  clientUtil;
    }

    public void listTopic(){
        System.out.println("get topics...");

        ListTopicsResult listTopicsResult =  client.listTopics();

        KafkaFuture<Set<String>> names =  listTopicsResult.names();

        try{
            Set<String>  nameSet =  names.get();

            System.out.println(nameSet);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void createTopic(){
        System.out.println("create Topic...");
        Collection<NewTopic> newTopics  = new ArrayList<>();
        NewTopic topic = new NewTopic("create-topic-"+ new Random().nextInt(100),20,(short)1);
        newTopics.add(topic);
        CreateTopicsResult result = client.createTopics(newTopics);

    }


}
