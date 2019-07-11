package com.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkInvocationHandler  implements InvocationHandler {

    private Object target = null;
    public JdkInvocationHandler(Object object){
        this.target = object;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(this.target,args);
        return result;
    }

    public  Object getProxy(){
        Object object =    Proxy.newProxyInstance(
                this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this);
        return  object;
    }

}
