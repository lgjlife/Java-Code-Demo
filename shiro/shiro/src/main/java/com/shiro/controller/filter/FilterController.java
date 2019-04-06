package com.shiro.controller.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: shiro
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-03 07:04
 **/

@Controller
@RequestMapping("/filter")
public class FilterController {

    private static final Logger log = LoggerFactory.getLogger("FilterController");

    @RequestMapping
    public String filter(){

        log.info("/filter");
        return "/filter/filter";
    }


    @RequestMapping("/anon")
    public String anon(){

        log.info("/filter/anon");
        return "/filter/filter";
    }

    @RequestMapping("/authc")
    public String authc(){

        log.info("/filter/authc");
        return "/filter/filter";
    }


    @RequestMapping("/roles")
    public String roles(){

        log.info("/filter/roles");
        return "/filter/filter";
    }

    @RequestMapping("perms")
    public String perms(){

        log.info("/filter/perms");
        return "/filter/filter";
    }

    @RequestMapping("/rest")
    public String rest(){

        log.info("/filter/rest");
        return "/filter/filter";
    }

    @RequestMapping("/port")
    public String port(){

        log.info("/filter/port");
        return "/filter/filter";
    }
}
