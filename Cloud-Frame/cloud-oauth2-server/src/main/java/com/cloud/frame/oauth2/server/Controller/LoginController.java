package com.cloud.frame.oauth2.server.Controller;

import com.cloud.frame.common.aop.syslog.anno.PrintUrlAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-12 02:42
 **/

@Controller
@Slf4j
public class LoginController {

    //private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @PrintUrlAnno
    @RequestMapping("/")
    @ResponseBody
    public String main(Principal user){



        if(user == null){
            log.debug("user is null");
        }
        else{
            log.debug("user = " + user.getName());
        }
        return "main";
    }


    @RequestMapping("/login")
    public String login(){

        log.info("访问 /login");
        return "/login/login";
    }

    @PrintUrlAnno
    @RequestMapping("/auth/login")
    public String loginPage(){

        return "/login/login";
    }

}
