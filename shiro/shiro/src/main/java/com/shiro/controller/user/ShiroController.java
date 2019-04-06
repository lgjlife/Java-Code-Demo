package com.shiro.controller.user;

import com.shiro.dao.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: shiro
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-01 18:58
 **/


@Controller
@RequestMapping("/session")
public class ShiroController {

    private static final Logger log = LoggerFactory.getLogger("SessionController");

    @GetMapping("/set")
    @ResponseBody
    public String setSession(){
        log.info("/session/set");


        Subject subject = SecurityUtils.getSubject();
        log.info("subject is null ? :" + (subject == null) );

        Session session = subject.getSession(true);
        log.info("session is null ? :" + (session == null) );
        if(session == null){
            log.info("session is null");
        }
        log.info(session.getId().toString());


        String key = "user";
        User user = new User();
        user.setActualName("sdafdasfdsf");
        session.setAttribute(key,user);

        User user1 = (User)session.getAttribute(key);
        log.info("user1.ActualName = " + user1.getActualName());


        return ""+session.getId().toString();
    }


    @GetMapping("/get")
    @ResponseBody
    public String getSession(){
        log.info("/session/get");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();



        String key = "user";
        User user = (User)session.getAttribute(key);


        log.info("user.ActualName = " + user.getActualName());
        return "user.ActualName = " + user.getActualName();

    }
}
