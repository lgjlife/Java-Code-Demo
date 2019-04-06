package com.peterwanghao.spring.cloud.oauth.authclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;

/**   
 * @ClassName:  CloudSiteController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午3:26:39
 * @version V1.0
 * 
 */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello From Auth-Client!";
    }

    @GetMapping("/personInfo")
    public ModelAndView person(Principal user) {
        ModelAndView mav = new ModelAndView("personinfo");
        String personResourceUrl = "http://localhost:9000/person";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        mav.addObject("user", user);

        System.out.println(user);
        return mav;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test ............." + new Date().toString();
    }


}
