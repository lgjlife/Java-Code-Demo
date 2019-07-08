package com.netty.nettysocket.coder;

import com.netty.nettysocket.json.GsonUtil;
import com.netty.nettysocket.message.Header;
import com.netty.nettysocket.message.NettyMessage;
import com.netty.nettysocket.pojo.User;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteOrder;


@Slf4j
public class NettyMessageDecode extends LengthFieldBasedFrameDecoder {

    public NettyMessageDecode(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    public NettyMessageDecode(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    public NettyMessageDecode(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    public NettyMessageDecode(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf byteBuf =  in;// (ByteBuf)super.decode(ctx, in);
        if(byteBuf == null){

            log.info("byteBuf is null!");
            return null;
        }

        NettyMessage nettyMessage = new NettyMessage();

        Header header = new Header();

        header.setType(byteBuf.readByte());
        header.setSessionID(byteBuf.readLong());
        header.setLength(byteBuf.readInt());
        header.setCrcCode(byteBuf.readInt());

        nettyMessage.setHeader(header);

        int bodyLength = byteBuf.readableBytes();
        byte[] body = new byte[bodyLength];
        byteBuf.readBytes(body);

        User user = GsonUtil.deserialize(body, User.class);
        nettyMessage.setBody(user);

        log.info("nettyMessage = " + nettyMessage);

        return nettyMessage;
    }
}
