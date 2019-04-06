package com.cloud.frame.auth.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-18 01:00
 **/

@Service
public class RibbonService {

    private  static  final Logger log = LoggerFactory.getLogger(RibbonService.class);

    @Autowired
    RestTemplate restTemplate;

    public String request(){
        return  restTemplate.getForObject("http://security-provider/hi",String.class);
    }
}
