package com.controller;


import com.dao.model.OsUser;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/** 
* @description:  
* @param:
* @return:  
* @author: Mr.lgj 
* @date: 6/29/18 
*/ 

@RestController
@RequestMapping("/mvc")
public class MvcTestController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /*
     * 1. value ,请求的URL的路径，支持URL模板，正则表达式
     * 2. method, HTTP请求方法，有GET,POST,PUT ,DELETE
     * 3. consumes, 请求的媒体类型，如 consumes="application/json",对应于请求的HTTP - Content-Type
     * 4. produces, 返回客户端的媒体类型， 如produces="application/json",对应于请求的HTTP - Accept
     * 5. params, 请求的参数，如params="sadsa"
     * 6. headers,请求的HTTP头的值，如header="dsadsa"
    */

    //URI路径匹配
    @ResponseBody
    @RequestMapping("/func1")
    public String func1(){
        log.info("访问/mvc/func1");
        return "/mvc/func1 Request Success";

    }
    //URI路径匹配
    @ResponseBody
    @RequestMapping("/func2/{id}")
    public String func2(@PathVariable("id") int id){

        log.info("访问/mvc/func2/{id}");
        log.info("id = " + id);
        return "/mvc/func2/{id} Request Success";

    }
    //URI路径匹配
    @ResponseBody
    @RequestMapping("/func3/**")
    public String func3(){
        log.info("访问/mvc/func3/**");
        return "/mvc/func3/** Request Success";

    }
    //HTTP method 匹配  GET
    @ResponseBody
    @GetMapping("/func4/get")
    public String func4(){
        log.info("访问/mvc/func4/get");
        return "/func4/get Request Success";

    }
    //HTTP method 匹配 POST
    @ResponseBody
    @PostMapping("/func5/post")
    public String func5(){
        log.info("访问/mvc/func5/post");
        return "/mvc/func5/post Request Success";

    }
    //HTTP method 匹配 DELETE
    @ResponseBody
    @DeleteMapping("/func6/delete")
    public String func6(){
        log.info("访问/mvc/func6/delete");
        return "/mvc/func6/delete Request Success";

    }
    //HTTP method 匹配 PUT
    @ResponseBody
    @PutMapping("/func7/put")
    public String func7(){
        log.info("访问/mvc/func7/put");
        return "/mvc/func7/put Request Success";

    }
    //请求的媒体类型 consumes
    @ResponseBody
    @RequestMapping(value="/func8",consumes = "application/json")
    public String func8(){
        log.info("访问/mvc/func8");
        return "/mvc/func8 Request Success";

    }
    //响应的媒体类型 produces
    @ResponseBody
    @RequestMapping(value="/func9",produces = "application/json")
    public String func9(){
        log.info("访问/mvc/func9");
        return "/mvc/func9 Request Success";

    }

}
