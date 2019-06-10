package com.clouder.frame.authprovider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-18 01:28
 **/
@Api("/aserver")
@RestController
public class ProviderController {


    private  static  final Logger log = LoggerFactory.getLogger(ProviderController.class);

    @ApiOperation(value="/name",notes = "根据ID获取用户",httpMethod="GET")
    @GetMapping("/aserver/hi")
    public  String hi(){
        log.info("访问ProviderController  /hi");
        return  "hi , " + "ProviderController +  Time = " + new Date().toString();
    }

}
