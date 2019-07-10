package com.netty.common.message;

import lombok.Data;


@Data
public final class NettyMessage {

    private Header header;
    private Object body;

}
