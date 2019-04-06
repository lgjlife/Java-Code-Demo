package com.ch9.target.advice;

import org.springframework.stereotype.Component;

/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-03 01:31
 **/

@Component
public class SecondTargetAdvice implements TargetAdvice {

    public String func1(Integer param){
        System.out.println("开始执行 "+ this.getClass()  + " -- func1 ") ;
        System.out.println("传入参数为：" +  param);
        return "执行 "+ this.getClass()  + " -- func1 的返回值";
    }

    public String func2(String param,Integer data){
        System.out.println("开始执行 "+ this.getClass()  + " -- func2 ") ;
        System.out.println("传入参数为：" +  "  param = " + param + "  data = " + data);
        return "执行 "+ this.getClass()  + " -- func2 的返回值";
    }

    protected String func3(Integer param){
        System.out.println("开始执行 "+ this.getClass()  + " -- func3 ") ;
        System.out.println("传入参数为：" +  param);
        return "执行 "+ this.getClass()  + " -- func3 的返回值";
    }


}
