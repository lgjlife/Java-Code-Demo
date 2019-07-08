package com.netty.nettysocket.server;

import com.netty.nettysocket.server.handle.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class NettyServer {

    private EventLoopGroup connectLoopGroup = new NioEventLoopGroup();
    private EventLoopGroup messageLoopGroup = new NioEventLoopGroup();
    private ServerBootstrap serverBootstrap = new ServerBootstrap();

    private ConcurrentHashMap<Integer,Channel> channelCache = new ConcurrentHashMap<>();

    public void init(){
        serverBootstrap.group(connectLoopGroup,messageLoopGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ChildChannelHandler());
    }

    public  void bind(int port ){

        log.info("服务端绑定端口[{}].....",port);
        serverBootstrap.bind(port).addListener(new GenericFutureListener(){

            @Override
            public void operationComplete(Future future) throws Exception {
                log.info("服务端绑定端口[{}]成功",port);
                Channel channel = ((ChannelFuture)future).channel();
                channelCache.put(port,channel);
            }
        });


    }






}
