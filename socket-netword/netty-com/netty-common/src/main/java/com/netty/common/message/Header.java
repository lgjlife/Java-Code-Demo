package com.netty.common.message;


import lombok.Data;

@Data
public final class Header {

    //一个字节
    private Byte type;
    //8个字节
    private long sessionID;
    private Integer length = 0;
    private int crcCode;



}
