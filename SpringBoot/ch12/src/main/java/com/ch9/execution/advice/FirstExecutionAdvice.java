package com.ch9.execution.advice;

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
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FirstExecutionAdvice   {

    public String func1(Integer param){
        System.out.println("开始执行 FirstExecutionAdvice -- func1 ") ;
        System.out.println("传入参数为：" +  param);
        return "执行 FirstExecutionAdvice -- func1 的返回值";
    }

    public String func2(String param,Integer data){
        System.out.println("开始执行 FirstExecutionAdvice -- func2 ") ;
        System.out.println("传入参数为：" +  "  param = " + param + "  data = " + data);
        return "执行 FirstExecutionAdvice -- func2 的返回值";
    }

    protected String func3(Integer param){
        System.out.println("开始执行 FirstExecutionAdvice -- func3 ") ;
        System.out.println("传入参数为：" +  param);
        return "执行 FirstExecutionAdvice -- func3 的返回值";
    }


}
