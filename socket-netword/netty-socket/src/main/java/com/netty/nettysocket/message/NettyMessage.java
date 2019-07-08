package com.netty.nettysocket.message;

import com.netty.nettysocket.pojo.User;
import lombok.Data;


@Data
public final class NettyMessage {

    private Header header;
    private User body;

}
