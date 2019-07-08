package com.netty.nettysocket.client;

import com.netty.nettysocket.client.handle.ChildChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class NettyClient {


    private EventLoopGroup messageLoopGroup = new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();

    private ConcurrentHashMap<Integer,Channel> channelCache = new ConcurrentHashMap<>();

    public void init(){
        bootstrap.group(messageLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChildChannelHandler());
    }

    public  void connect(String host , int port ){

        log.info("客户端正在连接服务端[{}-{}]....",host,port);
        bootstrap.connect(host,port).addListener(new GenericFutureListener<ChannelFuture>(){

            @Override
            public void operationComplete(ChannelFuture future) throws Exception {

                Channel channel = future.channel();
                if (channel.remoteAddress() == null){
                    log.info("客户端连接服务端[{}-{}]失败！重新连接",host,port);
                    try{
                        channel.close();
                        Thread.sleep(2000);
                        connect(host,port);
                    }
                    catch(Exception ex){
                        log.error(ex.getMessage());
                    }
                }
                else {
                    channelCache.put(port,channel);
                    log.info("客户端连接[{}]成功！",channel.remoteAddress());
                }
            }
        });
    }

    public void sendObject(Object object){

        channelCache.forEach((port,channel)->{
            if(channel.isActive()){
                channel.writeAndFlush(object).addListener(new GenericFutureListener<ChannelFuture>(){
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        log.info("客户端数据[{}]发送[{}]成功",object,channel.remoteAddress());
                    }
                });
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


    private ByteBuf StringToByteBuf(String data){
        byte[] byData = data.getBytes();
        ByteBuf byteBuf = Unpooled.buffer(byData.length);
        byteBuf.writeBytes(byData);
        return byteBuf;
    }





}
