package com.netty.nettysocket.client.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClientChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelRegistered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelUnregistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelInactive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        log.info("客户端 channelRead");
        log.info("客户端接收服务端数据:[{}]",msg);//ToByteBufToString((ByteBuf)msg));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelReadComplete");
    }

    private String ToByteBufToString(ByteBuf buf){

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        return new String(bytes);
    }


}
