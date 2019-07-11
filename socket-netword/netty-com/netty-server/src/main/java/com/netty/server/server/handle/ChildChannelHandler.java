package com.netty.server.server.handle;

import com.netty.common.coder.NettyMessageDecode;
import com.netty.common.coder.NettyMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        //pipeline.addLast(new LineBasedFrameDecoder(1024));
        //pipeline.addLast(new StringDecoder());
        pipeline.addLast(new NettyMessageDecode(1024*1024,9,
                4,0,0));
        pipeline.addLast(new NettyMessageEncoder());
        pipeline.addLast(new ServerChannelInboundHandlerAdapter());

        //pipeline.addLast(new ServerChannelOutboundHandlerAdapter());

    }
}
