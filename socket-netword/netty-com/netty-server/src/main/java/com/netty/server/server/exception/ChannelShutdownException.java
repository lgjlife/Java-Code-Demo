package com.netty.server.server.exception;

public class ChannelShutdownException extends  Exception {


    public ChannelShutdownException(String message) {
        super(message);
    }

    public ChannelShutdownException(String message, Throwable cause) {
        super(message, cause);
    }
}
