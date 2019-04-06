package com.cloud.frame.auth.user.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 17:21
 **/

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    private static final Logger log = LoggerFactory.getLogger(MyAccessDecisionManager.class);

    /** 
     * @description: Resolves an access control decision for the passed parameters.
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {


        log.info("访问MyAccessDecisionManager -- decide");

        ConfigAttribute c;
        String needRole;
        for(Iterator<ConfigAttribute> iter = collection.iterator(); iter.hasNext(); ) {
            c = iter.next();
            needRole = c.getAttribute();
            log.info(" needRole = " + needRole);
            for(GrantedAuthority ga : authentication.getAuthorities()) {
                //authentication 为在注释1 中循环添加到 GrantedAuthority 对象中的权限信息集合
                if(needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限");


    }
    


    /** 
     * @description:  Indicates whether this AccessDecisionManager is able to process
     * authorization requests presented with the passed ConfigAttribute.
     * @param:
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * @description:  Indicates whether the AccessDecisionManager implementation
     * is able to provide access control decisions for the indicated secured object type.
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 11/22/18
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
