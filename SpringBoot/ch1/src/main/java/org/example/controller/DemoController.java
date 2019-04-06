package org.example.controller;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public  String sayHello(){
        System.out.println("执行sayHello");
        return  "Hello,This is a  Springboot demo. ";
    }
}


