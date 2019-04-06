package com.cloud.frame.proxy.cgLibProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 21:11
 **/
public class CglibProxy  implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public  Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        before();
        Object result = methodProxy.invokeSuper(o,args);
        after();

        return result;
    }


    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }

}
