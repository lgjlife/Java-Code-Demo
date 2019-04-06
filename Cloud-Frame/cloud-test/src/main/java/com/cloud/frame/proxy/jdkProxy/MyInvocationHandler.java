package com.cloud.frame.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 18:57
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object target = null;
    public MyInvocationHandler(Object object){
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object ret = method.invoke(this.target,args);
        after();

        return ret;
    }

    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }


}
