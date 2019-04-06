package com.cloud.frame.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 19:04
 **/
public class MyProxy {

    private Object target = null;
    private InvocationHandler handler = null;
    public MyProxy(InvocationHandler handler,Object target){
        this.handler = handler;
        this.target = target;
    }
    Object getProxy(){
        Object object =    Proxy.newProxyInstance(
                this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this.handler);
        return  object;

    }
}
