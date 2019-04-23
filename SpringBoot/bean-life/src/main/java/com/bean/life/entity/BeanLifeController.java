package com.bean.life.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;


@Import(Demo1.class)
@Controller
public class BeanLifeController {

    @Autowired
    BeanLifeService beanLifeService;

    @Autowired
    ApplicationContext context;


    {
      //  Demo1 demo1 = context.getBean(Demo1.class);
      //  System.out.println("demo1 = " + demo1);
        System.out.println("BeanLifeController...");
    }
}
