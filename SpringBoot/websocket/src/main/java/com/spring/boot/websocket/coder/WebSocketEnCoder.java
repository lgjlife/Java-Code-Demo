package com.spring.boot.websocket.coder;

import com.spring.boot.websocket.message.Message;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


@Slf4j
public class WebSocketEnCoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message message) throws EncodeException {

        log.info("WebSocketEnCoder encode.....................");

        return "asdsadsadwa";
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
