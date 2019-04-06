package com.cloud.frame.security.service.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-12 02:42
 **/

@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(){

        log.info("访问 /login");
        return "/login/login";
    }
}
