package com.springboot.transaction.controller;


import com.springboot.transaction.service.trans.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransController {


    @Autowired
    private ServiceA serviceA;

    @GetMapping("/type1")
    public void type1(){

        serviceA.func1();
    }
    @GetMapping("/type2")
    public void type2(){
        serviceA.func2();
    }
    @GetMapping("/type3")
    public void type3(){
        serviceA.func3();
    }







}
