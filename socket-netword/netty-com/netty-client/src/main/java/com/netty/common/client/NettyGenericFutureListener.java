package com.netty.common.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NettyGenericFutureListener implements GenericFutureListener<ChannelFuture> {

    private ConcurrentHashMap<Integer,Channel> channelCache;
    private String host;
    private int port;
    private Bootstrap bootstrap;


    public NettyGenericFutureListener(ConcurrentHashMap<Integer, Channel> channelCache, String host, int port, Bootstrap bootstrap) {
        this.channelCache = channelCache;
        this.host = host;
        this.port = port;
        this.bootstrap = bootstrap;
    }

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
                    bootstrap.connect(host,port);
                }
            },5, TimeUnit.SECONDS);

        }
    }
}
