package com.ch11.controller;


import com.ch11.exception.FirstException;
import com.ch11.exception.SecondException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 00:40
 **/

@RestController
public class HelloController  {

    private  static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello/{id}")
    public  String hello(@PathVariable("id") Integer id) throws Exception{
       log.info("访问hello" + " id = " + id);

       if(id == 0){
           throw  new NullPointerException("指针异常");
       }
       else if(id == 1){
           throw  new Exception("访问 /hello/1 异常");
       }
       else if(id == 2){
            throw  new FirstException("1001","访问 /hello/2 异常");
       }
       else if(id == 3){
           throw  new SecondException("1002","访问 /hello/3 异常");
       }

       return  "访问 /hello 成功";
    }


}
