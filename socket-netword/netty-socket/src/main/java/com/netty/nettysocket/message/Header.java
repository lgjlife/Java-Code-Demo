package com.netty.nettysocket.message;


import lombok.Data;

@Data
public final class Header {

    //一个字节
    private Byte type;
    //8个字节
    private long sessionID;
    private Integer length;

    private int crcCode;



}
