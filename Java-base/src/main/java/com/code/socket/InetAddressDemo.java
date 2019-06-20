package com.code.socket;

import java.net.InetAddress;

public class InetAddressDemo {

    


    public static void main(String args[]) throws Exception{
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);


        System.out.println("LocalHost = "+ InetAddress.getLocalHost());
        System.out.println("LoopbackAddress = "+ InetAddress.getLoopbackAddress());


    }
}
