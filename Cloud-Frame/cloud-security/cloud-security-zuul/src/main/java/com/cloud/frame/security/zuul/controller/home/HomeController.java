package com.cloud.frame.security.zuul.controller.home;


import com.cloud.frame.security.zuul.aop.syslog.anno.PrintUrlAnno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: cloud-parent
 * @description: 主页访问
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-27 16:16
 **/

@Controller
@RequestMapping("/")
public class HomeController {

    @PrintUrlAnno(layer = "controller",description = "主页面")
    @RequestMapping
    public String loginPage(){

        System.out.println("/////////////////////////////");
        return "/home/index";
    }
}