package com.code.lambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class LambdaDemo {

    public void buildRequestHeader(BiConsumer<String,String> consumer, Map<String,String> requestHeader){
        if((requestHeader != null) && (!requestHeader.isEmpty())){
            requestHeader.forEach((k,v)->{
                consumer.accept(k,v);
            });
        }
    }

    public static void main(String args[]){

        Map<String,String> requestHeader = new LinkedHashMap<>();
        requestHeader.put("A1","A1-VALUE");
        requestHeader.put("A2","A2-VALUE");

        Map<String,String> httpGet = new LinkedHashMap<>();
        LambdaDemo demo = new LambdaDemo();
        demo.buildRequestHeader((k,v)->{
            httpGet.put(k,v);},requestHeader);

        System.out.println("httpGet = " + httpGet);

        Map<String,String> httpPost = new LinkedHashMap<>();
        demo.buildRequestHeader((k,v)->{
            httpPost.put(k,v);},requestHeader);

        System.out.println("httpPost = " + httpPost);


    }
}
