package com.utils.session;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;



/**
 * @program: shiro
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-02 13:56
 **/
public class SessionUtil {

    /** 
     * @description:  设置session ,不带time out
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    /*public static void setSession(String key,Object obj){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute(key,obj);
    }*/

    /** 
     * @description:  设置session ,带time out
     * @param:   timeout:minute
     * @return:
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    public static void setSession(String key,Object obj,long timeout){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setTimeout(timeout * 1000);
        session.setAttribute(key,obj);
    }

    /** 
     * @description: 获取session 
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    public static Object getSession(String key){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return session.getAttribute(key);
    }
}
