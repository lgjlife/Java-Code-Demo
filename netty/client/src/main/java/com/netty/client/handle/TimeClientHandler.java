package com.netty.client.handle;

import com.netty.common.coder.CoderUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TimeClientHandler extends ChannelHandlerAdapter {


    private ByteBuf resData;

    public TimeClientHandler() {

        String res = "客户端请求";
        byte[] resByte = res.getBytes();
        resData = Unpooled.buffer(resByte.length);
        resData.writeBytes(resByte);
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

        ByteBuf resData1;
        for (int i = 0; i < 2; i++) {

            // int i = 0;
            log.info("send count = " + i);
            /*String res = "客户端请求 "  + i;
            byte[] resByte = res.getBytes();
            log.info("resByte.length =" + resByte.length);
            resData1 = Unpooled.buffer(resByte.length);*/

            String res = "客户端请求" + i + "-----------" + CoderUtil.currentSeparator;
            byte[] resByte = res.getBytes();
            resData1 = Unpooled.buffer(resByte.length);
            resData1.writeBytes(resByte);


            // log.info(resData.toString());
            // log.info(resData1.toString());
            //  ctx.writeAndFlush(resData1);

            ctx.writeAndFlush(Unpooled.copiedBuffer(res.getBytes()));
        }


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //  super.channelRead(ctx, msg);
        log.info("TimeClientHandler   channelRead ");

       /* ByteBuf buf = (ByteBuf) msg;
        byte[] rec = new byte[buf.readableBytes()];
        buf.readBytes(rec);
        String  recStr =  new String(rec,"UTF-8");
        log.info("接受的数据为：" + recStr);*/

        log.info("接受的数据为：" + msg);

        ctx.close();

    }
}
