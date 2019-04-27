package com.springboot.transaction.controller;


import com.springboot.transaction.service.required.TransServiceRequiredA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransController {


    @Autowired
    TransServiceRequiredA transServiceRequiredA;

    @GetMapping("/required1")
    public void required1(){
        transServiceRequiredA.func1();
    }

    @GetMapping("/required2")
    public void required2(){
        transServiceRequiredA.func2();
    }

    @GetMapping("/required3")
    public void required3(){
        transServiceRequiredA.func3();
    }

    @GetMapping("/required4")
    public void required4(){
        transServiceRequiredA.func4();
    }




}
