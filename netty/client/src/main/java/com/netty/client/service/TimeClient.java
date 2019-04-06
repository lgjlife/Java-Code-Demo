package com.netty.client.service;


import com.netty.client.handle.ChildChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Service;

@Service
public class TimeClient {

    public void connect(int port, String host) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        try {

            Bootstrap bootstrap = new Bootstrap();


            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChildChannelHandler());

            ChannelFuture future = bootstrap.connect(host, port).sync();


            //  future.channel().closeFuture().sync();
            //   future.channel().close().sync();


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }


    }
}
