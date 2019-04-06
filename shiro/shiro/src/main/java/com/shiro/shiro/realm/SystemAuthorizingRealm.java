package com.shiro.shiro.realm;

import com.shiro.dao.model.User;
import com.shiro.service.UserLoginService;
import com.utils.UserLogin;
import com.utils.session.SessionUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: shiro
 * @description: shiro 认证realm
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 23:01
 **/

@Component
public class SystemAuthorizingRealm  extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger("UserLoginServiceImpl");

    @Autowired
    UserLoginService userLoginService;


    /** 
     * @description: 权限认证
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @Override
    public  AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection var1){

        log.info("进行权限验证 AuthorizationInfo......");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Set<String> roles = new HashSet<>();
        Set<String> perms = new HashSet<>();
        roles.add("user");
        roles.add("admin");
        perms.add("user:add:*");
        perms.add("read");
        perms.add("write");
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;

    }

    /** 
     * @description: 登录认证 
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException{

        log.info("SystemAuthorizingRealm　正在执行身份验证........");
        String loginName = (String)token.getPrincipal();
      //  String password = (String)token.getCredentials();
        log.info("loginName = " + loginName );


       // User user = (User)SessionUtil.getSession(UserLogin.currentLoginUser);
        User user = userLoginService.queryUser(loginName);
        if(user == null ){
            throw new UnknownAccountException();
        }

        /*
        * param1: 用户实体类
        * param2: 帐号对应的密码，不是原始密码，而是加密过后的密码
        * param3： 帐号加密用的salt,需要转化成ByteSource格式
        * param4: realm name

         */
        AuthenticationInfo authenticationInfo
                = new SimpleAuthenticationInfo(user,
                                               user.getLoginPassword(),
                                               ByteSource.Util.bytes(user.getSalt()),
                                               this.getName());
        return  authenticationInfo;

    }


}
