package com.cloud.frame.auth.user.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 17:51
 **/

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "/admin/home";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }
}

@Getter
@Setter
@AllArgsConstructor
class Msg implements Serializable {

    private  String title ;
    private  String content;
    private  String etraInfo;



}

