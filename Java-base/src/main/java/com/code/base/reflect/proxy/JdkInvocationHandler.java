package com.code.base.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkInvocationHandler  implements InvocationHandler {

    private Object target = null;
    public JdkInvocationHandler(Object object){
        this.target = object;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

      //  before();
        Object ret = method.invoke(this.target,args);
      //  after();

        return ret;
    }

    //@Override
   /* public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object ret = method.invoke(this.target,args);
        after();

        return ret;
    }*/

    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }


}
