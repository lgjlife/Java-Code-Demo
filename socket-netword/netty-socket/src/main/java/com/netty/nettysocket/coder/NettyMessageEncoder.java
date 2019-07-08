package com.netty.nettysocket.coder;

import com.netty.nettysocket.json.GsonUtil;
import com.netty.nettysocket.message.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage, List<Object> out) throws Exception {

        ByteBuf byteBuf = Unpooled.buffer();
        log.info("NettyMessageEncoder 发送解析 ： nettyMessage = " + nettyMessage);

        byteBuf.writeByte(nettyMessage.getHeader().getType());
        byteBuf.writeLong(nettyMessage.getHeader().getSessionID());
        byteBuf.writeInt(nettyMessage.getHeader().getLength());
        byteBuf.writeInt(nettyMessage.getHeader().getCrcCode());

        byte[] body =  GsonUtil.serialize(nettyMessage.getBody(),null);
        byteBuf.writeBytes(body);

        byteBuf.setInt(9,byteBuf.readableBytes());

        out.add(byteBuf);

    }
}
