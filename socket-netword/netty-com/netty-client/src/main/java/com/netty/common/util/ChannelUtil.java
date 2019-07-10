package com.netty.common.util;

import java.net.SocketAddress;

public class ChannelUtil {

    // /127.0.0.1:8512
    public static String  parseToHost(SocketAddress remoteAddress){
        String address = remoteAddress.toString();

        int end = address.indexOf(":");

        return address.substring(1,end);
    }
    public static int  parseToPort(SocketAddress remoteAddress){
        String address = remoteAddress.toString();

        int start = address.indexOf(":");

        return Integer.valueOf( address.substring(start+1,address.length()));

    }
}
