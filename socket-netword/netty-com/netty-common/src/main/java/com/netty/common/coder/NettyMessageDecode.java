package com.netty.common.coder;

import com.netty.common.message.Header;
import com.netty.common.message.NettyMessage;
import com.netty.common.pojo.User;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class NettyMessageDecode extends LengthFieldBasedFrameDecoder {

    public NettyMessageDecode(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }




    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {

        log.debug("×××××××××××××××××××××××decode  start×××××××××××××××××××××××");
        log.info("maxCapacity = " + byteBuf.maxCapacity());

        if(byteBuf == null){

            log.info("byteBuf is null!");
            return null;
        }

       if(byteBuf.readableBytes() > (MessageIndex.lengthIndex+4)){

            int lengthIndex = byteBuf.readerIndex()+MessageIndex.lengthIndex;
           log.info("lengthIndex = {}",lengthIndex);
            int messageLength = byteBuf.getInt(lengthIndex);
            log.debug("readerIndex={},writerIndex={},readableByte={},messageLength={}",
                    byteBuf.readerIndex(),byteBuf.writerIndex(),byteBuf.readableBytes(),messageLength);


           if( byteBuf.readableBytes() < messageLength ){

                log.debug("readableBytes is less then 100,return!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++",byteBuf.readableBytes() );
                return null;
            }

        }

        NettyMessage nettyMessage = new NettyMessage();

        Header header = new Header();

        header.setType(byteBuf.readByte());
        header.setSessionID(byteBuf.readLong());
        header.setLength(byteBuf.readInt());

        log.info("本次接收的总长度为:[{}]byte",header.getLength());
        header.setCrcCode(byteBuf.readInt());

        nettyMessage.setHeader(header);

        User user =  (User)MessageBodyUtil.decoder(byteBuf);
        nettyMessage.setBody(user);
        log.info("nettyMessage = " + nettyMessage);

        log.debug("×××××××××××××××××××××××decode end×××××××××××××××××××××××");

        return nettyMessage;
    }
}
