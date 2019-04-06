package com.cloud.frame.auth.user.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: top-parent
 * @description: 登录Controller
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 01:47
 **/

@Controller
@RequestMapping("/admin")
public class LoginController {

    private static  final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login/index")
    public String loginIndex(){
        log.info("访问 /admin/login/index");
        return "/admin/login-index";
    }
}
