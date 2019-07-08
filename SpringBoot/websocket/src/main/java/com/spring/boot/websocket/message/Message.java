package com.spring.boot.websocket.message;

import lombok.Data;

@Data
public class Message {

    private int code;
    private String name;
    private String msg;
}
