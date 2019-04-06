package com.cloud.frame.security.oauth2.controller.admin;

import com.cloud.frame.security.oauth2.aop.syslog.anno.PrintUrlAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-27 16:36
 **/

@RestController
public class AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @PrintUrlAnno
    @GetMapping("/admin")
    public Principal admin(Principal admin) {

        log.info("admin = " + admin.getName());
        log.info("admin = " + admin.toString());
        return admin;
    }
}
