package com.netty.common.client.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
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

        Channel channel = ctx.channel();
        EventLoop eventLoop =  channel.eventLoop();
  /*      eventLoop.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("客户端连接服务端[{}-{}]失败！重新连接",channel.remoteAddress());
               // connect(host,port);
            }
        },0,3, TimeUnit.SECONDS);*/



        super.channelUnregistered(ctx);

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
