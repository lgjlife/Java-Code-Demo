package com.shiro.shiro.cache;

import com.redis.Utils.RedisStringsUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @program: shiro
 * @description: SessionDao实现
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-01 17:59
 **/

@Component
public class ShiroSessionDao extends CachingSessionDAO {

    private static final Logger log = LoggerFactory.getLogger("ShiroSessionDao");

    //用作key的前缀，key = keyPrefix + session_id
    private String keyPrefix = "SHIRO_REDIS_SESSION:";
    //session 缓存过期时间
  //  private static  final int cacheTimeMinute = 30;

    @Autowired
    private RedisStringsUtil<String,Session> redisStringsUtil;
    /** 
     * @description:  
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/1/18 
    */ 
    @Override
    protected void doUpdate(Session session) {
        long  cacheTimeMinute = session.getTimeout();
        redisStringsUtil.set(getKey(session.getId().toString()),session,cacheTimeMinute,TimeUnit.MILLISECONDS);
    }

    /** 
     * @description:  
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/1/18 
    */ 
    @Override
    protected void doDelete(Session session) {
        redisStringsUtil.delete(getKey(session.getId().toString()));

    }

    /** 
     * @description:  
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/1/18 
    */ 
    @Override
    protected Serializable doCreate(Session session) {

        if(session == null){
            log.info("session is null");
        }
        log.info("doCreate");
        long  cacheTimeMinute = session.getTimeout();
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        log.info("session.toString"+session.toString());
        log.info(""+session.getHost());
        log.info(session.getId()+"");
        redisStringsUtil.set(getKey(session.getId().toString()),session,cacheTimeMinute,TimeUnit.MILLISECONDS);
        return sessionId;
    }

    /** 
     * @description:
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/1/18 
    */ 
    @Override
    protected Session doReadSession(Serializable serializable) {

        log.info("doReadSession");

        log.info("serializable session id = " + serializable);
        String key = getKey(serializable.toString());

        Session session =  redisStringsUtil.get(key);
        log.info("doReadSession -- serializable.toString()" + serializable.toString());
        if(session == null){
            log.debug("session is null!");
        }
        return session;
    }

    private String getKey(String sessionId){
        return keyPrefix + sessionId;
    }
}
