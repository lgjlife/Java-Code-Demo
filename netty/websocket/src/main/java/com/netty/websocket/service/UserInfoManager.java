package com.netty.websocket.service;

import com.netty.websocket.pojo.UserInfo;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class UserInfoManager {

    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    private static ConcurrentMap<Channel, UserInfo> userInfos = new ConcurrentHashMap<>();

    /**
     * 登录注册 channel
     */
    public static void addChannel(Channel channel, String uid) {
        String remoteAddr = channel.remoteAddress().toString();// NettyUtil.parseChannelRemoteAddr(channel);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(uid);
        userInfo.setAddr(remoteAddr);
        userInfo.setChannel(channel);
        userInfos.put(channel, userInfo);
    }

    /**
     * 普通消息
     *
     * @param message
     */
    public static void broadcastMess(String uid, String message, String sender) {
        //  if (!BlankUtil.isBlank(message))
        {
            try {
                rwLock.readLock().lock();
                Set<Channel> keySet = userInfos.keySet();
                for (Channel ch : keySet) {
                    UserInfo userInfo = userInfos.get(ch);
                    if (!userInfo.getUserId().equals(uid)) continue;
                    String backmessage = sender + "," + message;
                    log.info("发送消息");
                    ch.writeAndFlush(new TextWebSocketFrame(backmessage));
                    // responseToClient(ch,message);
                }
            } finally {
                rwLock.readLock().unlock();
            }
        }
    }

    public static UserInfo getUserInfo(Channel channel) {
        return userInfos.get(channel);
    }

    public static void showUserInfo() {
        Collection<UserInfo> us = userInfos.values();
        log.info("当前登录的用户");
        for (UserInfo u : us) {
            System.out.println(u);
        }
    }


}
