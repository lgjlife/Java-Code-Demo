package com.shiro.controller.filter;

import org.apache.shiro.authz.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: shiro
 * @description: 权限
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-03 16:11
 **/

@Controller
@RequestMapping("/perms")
public class PermsController {

    private static final Logger log = LoggerFactory.getLogger("FilterController");

    /*
     * 1.RequiresAuthentication:
     * 使用该注解标注的类，实例，方法在访问或调用时，当前Subject必须在当前session中已经过认证。
     * 2.RequiresGuest:
     * 使用该注解标注的类，实例，方法在访问或调用时，当前Subject可以是“guest”身份，
     * 不需要经过认证或者在原先的session中存在记录。
     * 3.RequiresPermissions:
     * 当前Subject需要拥有某些特定的权限时，才能执行被该注解标注的方法。
     * 如果当前Subject不具有这样的权限，则方法不会被执行。
     * 4.RequiresRoles:
     * 当前Subject必须拥有所有指定的角色时，才能访问被该注解标注的方法。
     * 如果当天Subject不同时拥有所有指定角色，则方法不会执行还会抛出AuthorizationException异常。
     * 5.RequiresUser
     * 当前Subject必须是应用的用户，才能访问或调用被该注解标注的类，实例，方法。
     */
    @RequestMapping("/requiresAuthentication/1")
    @RequiresAuthentication
    public String requiresAuthentication(){

        log.info("/perms/1 --------RequiresAuthentication");
        return "/filter/filter";
    }
    @RequiresGuest
    @RequestMapping("/requiresGuest/2")
    public String requiresGuest(){

        log.info("/perms/2 --------requiresGuest");
        return "/filter/filter";
    }
    @RequiresPermissions(value={"read","write"},logical = Logical.OR)
    @RequestMapping("/requiresPermissions/3")
    public String requiresPermissions(){

        log.info("/perms/3 --------requiresPermissions");
        return "/filter/filter";
    }
    @RequiresRoles(value={"user","admin"},logical = Logical.OR)
    @RequestMapping("/requiresRoles/4")
    public String requiresRoles(){

        log.info("/perms/4 --------requiresRoles");
        return "/filter/filter";
    }
    @RequiresUser
    @RequestMapping("/requiresUser/5")
    public String requiresUser(){

        log.info("/perms/5 --------requiresUser");
        return "/filter/filter";
    }
}
