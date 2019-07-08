package com.netty.nettysocket.server.handle;

import com.netty.nettysocket.message.Header;
import com.netty.nettysocket.message.NettyMessage;
import com.netty.nettysocket.pojo.User;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class ServerChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {

    private AtomicInteger recCount = new AtomicInteger(0);


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);

        log.info("服务端channelRegistered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        log.info("服务端channelUnregistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("服务端channelActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("服务端channelInactive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      //  super.channelRead(ctx, msg);
        log.info("服务端channelRead-{}",recCount.incrementAndGet());
        log.info("服务端接收客户端数据:[{}]",msg);//ToByteBufToString((ByteBuf)msg));

      //  ctx.channel().writeAndFlush(StringToByteBuf("这是服务端返回的数据\r\n"));

        ctx.channel().writeAndFlush(buildNettyMessage());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        log.info("服务端channelReadComplete");
    }

    private ByteBuf StringToByteBuf(String data){
        byte[] byData = data.getBytes();
        ByteBuf byteBuf = Unpooled.buffer(byData.length);
        byteBuf.writeBytes(byData);

        return byteBuf;
    }

    private String ToByteBufToString(ByteBuf buf){

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);

        return new String(bytes);
    }

    private NettyMessage buildNettyMessage(){

        NettyMessage nettyMessage = new NettyMessage();
        Header header = new Header();
        header.setType((byte)1);
        header.setSessionID(1201);
        header.setCrcCode(453);
        header.setLength(0);
        nettyMessage.setHeader(header);

        User user = new User();
        user.setName("Server");
        user.setAge(145);

        nettyMessage.setBody(user);
        return nettyMessage;
    }



}
