package com.fastdfs.fastdfs.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public  Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

   /* @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        before();
        Object result = methodProxy.invokeSuper(o,args);
        after();

        return result;
    }*/

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

       // before();
        Object result = methodProxy.invokeSuper(o,objects);
      //  after();

        return null;
    }

    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }

}

