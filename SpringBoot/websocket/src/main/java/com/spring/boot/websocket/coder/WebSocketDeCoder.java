package com.spring.boot.websocket.coder;

import com.alibaba.fastjson.JSON;
import com.spring.boot.websocket.message.Message;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

@Slf4j
public class WebSocketDeCoder implements Decoder.Text<Message> {



    @Override
    public Message decode(String body) throws DecodeException {

        log.info("body");

        Message message = JSON.parseObject(body,Message.class);

        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        log.info("init...");
    }

    @Override
    public void destroy() {

    }

    public static void main(String args[]){

        Message message = new Message();
        message.setName("sfa ");
        message.setCode(101);
        message.setMsg("dsfvadfvgsadsffds");
        String body = JSON.toJSONString(message);
        log.info("body = "+body);

        Message message1 = JSON.parseObject(body,Message.class);

        WebSocketDeCoder deCoder = new WebSocketDeCoder();

        try{

            deCoder.decode(body);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }



        log.info("message1 = "+message1);

    }
}
