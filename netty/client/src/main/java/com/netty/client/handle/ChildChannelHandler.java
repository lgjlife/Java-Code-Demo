package com.netty.client.handle;


import com.netty.common.config.CoderConfig;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
          socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
          socketChannel.pipeline().addLast(new StringDecoder());
        // socketChannel.pipeline().addLast(new StringEncoder());

        //配置编解码
        //  CoderUtil.DelimiterBasedFramDecoder(socketChannel,1024);
        //   socketChannel.pipeline().addLast(new TimeClientHandler());

        //   socketChannel.pipeline().addLast(new MsgpackDecoder());
        //   socketChannel.pipeline().addLast(new MsgpackEncoder());


        CoderConfig.JsonCoder(socketChannel);
        socketChannel.pipeline().addLast(new MsgpackClientHandler());
    }
}
