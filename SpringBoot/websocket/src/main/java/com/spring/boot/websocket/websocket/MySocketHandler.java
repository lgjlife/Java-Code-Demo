package com.spring.boot.websocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Slf4j
@Component
public class MySocketHandler extends AbstractWebSocketHandler {

    public static final String path = "/ws/asset";


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        log.info("afterConnectionEstablished");
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        log.info("handleMessage");


        log.info("收到消息:" + webSocketMessage.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.info("handleTransportError");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        log.info("afterConnectionClosed");
    }

    @Override
    public boolean supportsPartialMessages() {

        log.info("supportsPartialMessages");
        return false;
    }
}
