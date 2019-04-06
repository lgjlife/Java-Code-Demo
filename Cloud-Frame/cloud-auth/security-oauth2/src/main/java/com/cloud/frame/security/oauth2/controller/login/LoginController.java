package com.cloud.frame.security.oauth2.controller.login;

import com.cloud.frame.security.oauth2.aop.syslog.anno.PrintUrlAnno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: top-parent
 * @description: 登录
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-23 16:20
 **/

@Controller
@RequestMapping
public class LoginController {


    @PrintUrlAnno
    @GetMapping("/")
    @ResponseBody
    public  String main(){

        return "访问/";
    }
    /** 
     * @description:  获取登录页面 
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/23/18 
    */ 
    @PrintUrlAnno
    @GetMapping("/login")
    public  String loginIndex(){
       // System.out.println(user.getName());
        return "/login";
    }

    @PrintUrlAnno
    @PostMapping("/login/success")
    public  String loginSuccess(){
        return "/login-success";
    }

    @PrintUrlAnno
    @GetMapping("/logout/success")
    public  String logoutSuccess(){
        return "/logout-success";
    }


   /* @PrintUrlAnno
    @PostMapping
    public String */


}
