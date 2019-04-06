package com.mq.kafka.count;

import java.util.concurrent.atomic.AtomicInteger;

public class KafkaCountUtil {

    private static AtomicInteger  recCount = new AtomicInteger(0);
    private static AtomicInteger  sendCout = new AtomicInteger(0);


    public static int  incAndGetRecCount(){
        return  recCount.incrementAndGet();
    }
    public static int  incAndGetSendCount(){
        return  sendCout.incrementAndGet();
    }


    public static  AtomicInteger getRecCount() {
        return recCount;
    }

    public static AtomicInteger getSendCout() {
        return sendCout;
    }
}
