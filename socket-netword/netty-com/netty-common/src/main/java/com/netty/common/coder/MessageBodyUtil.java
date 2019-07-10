package com.netty.common.coder;

import com.netty.common.json.GsonUtil;
import com.netty.common.pojo.User;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageBodyUtil {

    public static ByteBuf encoder(Object body,ByteBuf byteBuf){

        if(body == null){
            return  byteBuf;
        }

        byte[] bodyByte =  GsonUtil.serialize(body,null);
        log.debug("bodyLength = {},readerIndex={},writerIndex={}" ,bodyByte.length,byteBuf.readerIndex(),byteBuf.writerIndex());
        byteBuf.writeInt(bodyByte.length);

        byteBuf.writeBytes(bodyByte);

        return byteBuf;
    }

    public static Object decoder(ByteBuf byteBuf){

        log.debug("readerIndex={},writerIndex={}",byteBuf.readerIndex(),byteBuf.writerIndex());
        int bodyLength = byteBuf.readInt();

        log.debug("body长度 = {},readerIndex={},writerIndex={}" ,bodyLength,byteBuf.readerIndex(),byteBuf.writerIndex());
        byte[] bodyByte = new byte[bodyLength];
        byteBuf.readBytes(bodyByte);

        User user = GsonUtil.deserialize(bodyByte, User.class);
        return user;

    }



}
