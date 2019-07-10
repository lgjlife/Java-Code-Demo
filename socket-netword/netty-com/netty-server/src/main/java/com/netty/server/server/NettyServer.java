package com.netty.server.server;


import com.netty.server.server.handle.ChildChannelHandler;
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

    private EventLoopGroup connectLoopGroup = new NioEventLoopGroup(1);
    private EventLoopGroup messageLoopGroup = new NioEventLoopGroup(1);
    private ServerBootstrap serverBootstrap = new ServerBootstrap();

    private ConcurrentHashMap<Integer,Channel> channelCache = new ConcurrentHashMap<>();

    public void init(){
        serverBootstrap.group(connectLoopGroup,messageLoopGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,2048)
                .option(ChannelOption.SO_SNDBUF,102400)
                .option(ChannelOption.SO_RCVBUF,102400)
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

    public void close(int port){

        try{
            Channel channel = channelCache.get(port);
            log.debug("channel[{}] state : [isActive = {},isOpen= {},isWritable= {}] ",channel,channel.isActive(),channel.isOpen(),channel.isWritable());

            channel.disconnect().sync();
            log.info("channel[{}] 关闭！",channel);

            log.debug("channel[{}] state : [isActive = {},isOpen= {},isWritable= {}] ",channel,channel.isActive(),channel.isOpen(),channel.isWritable());
           // channelCache.remove(port);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

    }







}
