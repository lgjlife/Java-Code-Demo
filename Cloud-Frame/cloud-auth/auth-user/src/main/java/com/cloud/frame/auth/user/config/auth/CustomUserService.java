package com.cloud.frame.auth.user.config.auth;

import com.cloud.frame.auth.user.dao.mapper.AdminMapper;
import com.cloud.frame.auth.user.dao.mapper.PermissionMapper;
import com.cloud.frame.auth.user.dao.model.Admin;
import com.cloud.frame.auth.user.dao.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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

//@Component
public class CustomUserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);


    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        log.info("loadUserByUsername , name = " + name);

        Admin admin = adminMapper.selectByName(name);

        if(admin != null){
            List<Permission>  permissions = permissionMapper.selectByAdminId(admin.getAid());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            for(Permission permission : permissions){
                if((permission != null) && (permission.getName() != null)){

                    //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }

            return new User(admin.getName(),admin.getPassword(),grantedAuthorities);
        }
        else {
            throw new UsernameNotFoundException("admin: " + name + " do not exist!");
        }

    }
}
