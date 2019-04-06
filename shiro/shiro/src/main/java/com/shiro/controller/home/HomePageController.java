package com.shiro.controller.home;

import com.shiro.dao.model.User;
import com.utils.CheckNullUtil;
import com.utils.UserLogin;
import com.utils.session.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: shiro
 * @description: 主页Controller
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 16:44
 **/

@Controller
@RequestMapping("/")
public class HomePageController {

    private static final Logger log = LoggerFactory.getLogger("HomePageController");

    @GetMapping
    public String homePage(){

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        log.info("\n  SESSION ID = " + session.getId()
                + "\r\n  SESSION HOST = " + session.getHost()
                + "\r\n  AttributeKeys = " + session.getAttributeKeys()
                + "\r\n  LastAccessTime" + session.getLastAccessTime()
                + "\r\n Timeout" + session.getTimeout());

        return  "/home/HomePage";

    }

    @GetMapping("home")
   // @ResponseBody
    public ModelAndView home(){

        log.info("/home");
        User user = (User) SessionUtil.getSession(UserLogin.currentLoginUser);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home/home");
        String  loginName = "" ;

        if(user != null){
            if(!CheckNullUtil.isNullString(user.getNickName())){
                loginName = user.getNickName();
            }
            else if(!CheckNullUtil.isNullString(user.getEmail())){
                loginName = user.getEmail();
            }
            else if(!CheckNullUtil.isNullString(user.getPhoneNum())){
                loginName = user.getPhoneNum();
            }
            mv.addObject("loginName",loginName);
            log.info("loginName =  " + loginName);
            return  mv;
        }
        else {
            log.error("user  is null !");
        }

        return new ModelAndView("/home/HomePage");


    }

}
