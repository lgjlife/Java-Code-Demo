package com.netty.common.client.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClientChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("与服务端[{}]建立连接",ctx.channel().remoteAddress());
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与服务端[{}]断开连接",ctx.channel().remoteAddress());
        ctx.fireChannelInactive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        log.info("客户端 channelRead");
        log.info("客户端接收服务端数据:[{}]",msg);//ToByteBufToString((ByteBuf)msg));

        //ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        log.info("客户端 channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("IO发生异常:"+cause.getMessage());
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
    }

    private String ToByteBufToString(ByteBuf buf){

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        return new String(bytes);
    }


}
