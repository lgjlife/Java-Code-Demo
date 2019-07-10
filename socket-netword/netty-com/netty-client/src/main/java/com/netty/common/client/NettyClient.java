package com.netty.common.client;

import com.netty.common.client.handle.ChildChannelHandler;
import com.netty.common.util.ChannelUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@Slf4j
public class NettyClient {


    private EventLoopGroup messageLoopGroup = new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();

    private ConcurrentHashMap<Integer,Channel> channelCache = new ConcurrentHashMap<>();

    public void init(){
        bootstrap.group(messageLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .option(ChannelOption.SO_SNDBUF,102400)
                .option(ChannelOption.SO_RCVBUF,102400)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,3000)
                .handler(new ChildChannelHandler());
    }

    public  void connect(String host , int port ){

        log.info("客户端正在连接服务端[{}-{}]....",host,port);
        ChannelFuture channelFuture = bootstrap.connect(host,port);
        channelFuture.addListener(new GenericFutureListener<ChannelFuture>() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    channelCache.put(port,future.channel());
                    log.info("客户端连接[{}]成功！",future.channel().remoteAddress());
                }
                else {
                    Channel channel = future.channel();
                    EventLoop eventLoop =  channel.eventLoop();
                    ScheduledFuture scheduledFuture = eventLoop.schedule(new Runnable() {
                        @Override
                        public void run() {
                            log.info("客户端连接服务端[{}-{}]失败！重新连接",host,port);
                            connect(host,port);
                        }
                    },5, TimeUnit.SECONDS);

                }
            }
        });
    }
    public  void connect(SocketAddress remoteAddress){
        log.info("客户端正在连接服务端[{}]....",remoteAddress);
        String host = ChannelUtil.parseToHost(remoteAddress);
        int port = ChannelUtil.parseToPort(remoteAddress);
        connect(host,port);
    }




    public void sendObject(Object object){

        channelCache.forEach((port, channel) -> {
            //log.debug("channel state : [isActive = {},isOpen= {},isWritable= {}] ", channel.isActive(), channel.isOpen(), channel.isWritable());
            if (channel.isActive()) {
                channel.writeAndFlush(object).addListener(new GenericFutureListener<ChannelFuture>() {
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        log.info("客户端数据[{}]发送[{}]成功", object, channel.remoteAddress());
                    }
                });
            } else {
                log.debug("channel[{}]已经关闭", channel);
                connect(channel.remoteAddress());
            }
        });

    }

    public void send(String data){
       for(int i = 0; i< 1; i++){

           channelCache.forEach((port,channel)->{
               if(channel.isActive()){
                   channel.writeAndFlush(StringToByteBuf(data+"\r\n")).addListener(new GenericFutureListener<ChannelFuture>(){
                       @Override
                       public void operationComplete(ChannelFuture channelFuture) throws Exception {
                           log.info("客户端数据[{}]发送[{}]成功",data,channel.remoteAddress());
                       }
                   });
               }
           });
       }
    }


    public void close(int port){

        try{
            channelCache.get(port).close().sync();
            log.info("channel[{}] 关闭！",channelCache.get(port));
            //channelCache.remove(port);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

    }


    private ByteBuf StringToByteBuf(String data){
        byte[] byData = data.getBytes();
        ByteBuf byteBuf = Unpooled.buffer(byData.length);
        byteBuf.writeBytes(byData);
        return byteBuf;
    }





}
