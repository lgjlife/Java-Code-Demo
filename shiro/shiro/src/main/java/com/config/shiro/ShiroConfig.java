package com.config.shiro;

import com.shiro.shiro.realm.SystemAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: shiro
 * @description: Shiro配置类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 22:33
 **/
@Configuration
public class ShiroConfig {



    /** 
     * @description:  安全管理器
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm,
                                                     CacheManager cacheManager,
                                                     CookieRememberMeManager rememberMeManager,
                                                     SessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setCacheManager(cacheManager);
        //securityManager.setRememberMeManager(rememberMeManager);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }


    /**
     * @description: Cookie
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 8/31/18
     */
    @Bean
    public Cookie cookie(){
        Cookie cookie = new SimpleCookie("CookieRemember");
        cookie.setHttpOnly(true);
        //cookie 生效时间　，单位s

        cookie.setMaxAge(30*24*60*60);
        return cookie;

    }
    /** 
     * @description:  记住我管理器
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @Bean
    public  CookieRememberMeManager  rememberMeManager(Cookie cookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();

        byte[] cipherKey = Base64.decode("wGiHplamyXlVB11UXWol8g==");
        System.out.println("cipherKey = " + cipherKey.length + " " + cipherKey.toString());
        rememberMeManager.setCipherKey(cipherKey);
        rememberMeManager.setCookie(cookie);
        return rememberMeManager;
    }



    /** 
     * @description:  登录，权限认证
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @Bean
    public SystemAuthorizingRealm systemAuthorizingRealm(HashedCredentialsMatcher matcher){
        SystemAuthorizingRealm realm = new SystemAuthorizingRealm();
        realm.setCredentialsMatcher(matcher);

        return  realm;
    }


    @Bean
    public HashedCredentialsMatcher credentialsMatcher (){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(3);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return  credentialsMatcher;
    }
    @Bean
    public SimpleCookie  simpleCookie(){
        SimpleCookie simpleCookie   = new SimpleCookie("SimpleCookie");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);
        return  simpleCookie;
    }


    @Bean
    public DefaultWebSessionManager sessionManager(Cookie cookie,
                                                   SessionDAO sessionDAO){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(30*60*1000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(cookie);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionDAO(sessionDAO);
        return  sessionManager;

    }



    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor
                = new LifecycleBeanPostProcessor();
        return  lifecycleBeanPostProcessor;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator
                = new DefaultAdvisorAutoProxyCreator();
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor =
                new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return  advisor;
    }

    @Bean
    MemoryConstrainedCacheManager cacheManager(){
        MemoryConstrainedCacheManager cacheManager = new MemoryConstrainedCacheManager();
        return  cacheManager;
    }





}
