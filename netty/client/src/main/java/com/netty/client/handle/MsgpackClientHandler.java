package com.netty.client.handle;

import com.netty.common.pojo.TestUser;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MsgpackClientHandler extends ChannelHandlerAdapter {

    public MsgpackClientHandler() {


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        log.info("TimeClientHandler   exceptionCaught ");
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //  super.channelActive(ctx);
        log.info("连接成功！");


        for (int i = 0; i < 100; i++) {
            TestUser user = new TestUser("我来自客户端", i, 111);
            ctx.writeAndFlush(user);
        }
        //  ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //  super.channelRead(ctx, msg);
        log.info("TimeClientHandler   channelRead ");
        log.info("正在读取来自服务端的数据.........");
        log.info("接受的数据为：" + msg);

        // ctx.close();

    }
}
