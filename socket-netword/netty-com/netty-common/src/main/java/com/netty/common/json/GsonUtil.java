package com.netty.common.json;

import com.google.gson.Gson;
import com.netty.common.message.Header;
import com.netty.common.message.NettyMessage;
import com.netty.common.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Slf4j
@Component
public class GsonUtil implements Serializable {

    private static  Gson gson = new Gson();

    public static byte[] serialize(Object object,Class clz){
        byte[] result;
       String jsonStr =  gson.toJson(object);

        return jsonStr.getBytes();

    }

    public static <T> T deserialize(byte[] body,Class<? extends T> clz){
        return gson.fromJson(new String(body),clz);
    }


    public static void main(String args[]){

        User user = new User();
        user.setAge(12);
        user.setName("libai ");


        GsonUtil gsonUtil = new GsonUtil();
        byte[] body = gsonUtil.serialize(buildNettyMessage().getBody(),Object.class);
        User result = (User)gsonUtil.deserialize(body,User.class);

        log.info("result = " +result);

    }

    private static NettyMessage buildNettyMessage(){

        NettyMessage nettyMessage = new NettyMessage();
        Header header = new Header();
        header.setType((byte)1);
        header.setSessionID(1001);
        header.setCrcCode(123);
        header.setLength(0);
        nettyMessage.setHeader(header);

        User user = new User();
        user.setName("Client");
        user.setAge(18);

        nettyMessage.setBody(user);
        return nettyMessage;
    }




}



