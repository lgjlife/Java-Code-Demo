package com.dubbo.frame.rabbitmq.sender.config.rabbitmq;

public enum ExchangeType {

    fanout("fanout"),
    direct("direct"),
    topic("topic"),
    headers("headers");

    private String name;

    ExchangeType(String name) {
        this.name = name;
    }
}
