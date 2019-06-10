package com.cloud.frame.security.oauth2.controller;

import com.cloud.frame.security.oauth2.service.RibbonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-17 14:59
 **/

@Api("/aserver")
@RestController
@RequestMapping("/aserver")
public class UserController {

    private static  final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    RibbonService ribbonService;

    @ApiOperation(value="/name",notes = "根据ID获取用户",httpMethod="GET")
    @GetMapping("/name")
    public String queryUser(){

        log.info("访问 /aserver/name");
        return  "访问 /aserver/name , 当前时间：" + new Date().toString();
    }

    @ApiOperation(value="/hi",notes = "根据ID获取用户",httpMethod="GET")
    @GetMapping("/hi")
    public  String hi(){
        log.info("UserController  /hi");
        return  ribbonService.request();
    }

}
