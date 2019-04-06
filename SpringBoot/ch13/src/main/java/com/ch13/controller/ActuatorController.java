package com.ch13.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-06 01:00
 **/

@Controller
@RequestMapping("/actuator")
public class ActuatorController {

    private  static Logger log = LoggerFactory.getLogger(ActuatorController.class);

    @RequestMapping("/menu")
    public String menu(){
        log.info("访问 /actuator/menu");
        return "ch13/actuator";
    }
}
