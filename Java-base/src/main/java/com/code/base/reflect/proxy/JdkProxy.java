package com.code.base.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxy {
    private Object target = null;
    private InvocationHandler handler = null;
    public JdkProxy(InvocationHandler handler,Object target){
        this.handler = handler;
        this.target = target;
    }
    public  Object getProxy(){
        Object object =    Proxy.newProxyInstance(
                this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this.handler);
        return  object;

    }


}
