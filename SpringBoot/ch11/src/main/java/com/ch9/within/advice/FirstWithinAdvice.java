package com.ch9.within.advice;

import com.ch9.within.NeetAspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
@EnableAspectJAutoProxy(proxyTargetClass = true)
@NeetAspect
public class FirstWithinAdvice   {

    public FirstWithinAdvice() {
    }

    // @AspectAnno

    public String func1(Integer param){
        System.out.println("开始执行 "+ this.getClass()  + "-- func1 ") ;
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

    public String func4(SecondWithinAdvice secondArgsAdvice){
        System.out.println("开始执行 "+ this.getClass()  + " -- func4 ") ;

        return "执行 "+ this.getClass()  + " -- func4 的返回值";
    }



}
