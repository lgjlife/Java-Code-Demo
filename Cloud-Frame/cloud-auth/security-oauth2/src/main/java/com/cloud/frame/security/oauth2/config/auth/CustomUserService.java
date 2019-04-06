package com.cloud.frame.security.oauth2.config.auth;

import com.cloud.frame.security.oauth2.dao.mapper.AdminMapper;
import com.cloud.frame.security.oauth2.dao.mapper.PermissionMapper;
import com.cloud.frame.security.oauth2.dao.model.Admin;
import com.cloud.frame.security.oauth2.dao.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 16:22
 **/

@Component
public class CustomUserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);


    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PermissionMapper permissionMapper;

    /** 
     * @description:  加载用户名和对应的用户权限,只有在密码登录的时候才会执行
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/23/18 
    */ 
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        log.info("loadUserByUsername , name = " + name);

       // Admin admin0 = adminMapper.selectByPrimaryKey(1);
      //  log.info("admin = " + admin0.toString());

        Admin admin = adminMapper.selectByName(name);

        if(admin != null){
            log.info("开始查询权限.....");
            log.info("admin = " + admin.toString());
            List<Permission>  permissions = permissionMapper.selectByAdminId(admin.getAid());
            log.info("permissiom.len = " + permissions.size());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            for(Permission permission : permissions){
                if((permission != null) && (permission.getName() != null)){

                    log.info("name = " + name +   "; permission = " + permission.getName());
                    //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }

            return new User(admin.getName(),admin.getPassword(),grantedAuthorities);
        }
        else {

            log.info("admin - {} 不存在",name );
            throw new UsernameNotFoundException("admin: " + name + " do not exist!");
        }

    }
}
