package com.code.base.reflect.proxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

public class JavassistProxy {

    public Object getProxy(Class clazz) throws InstantiationException, IllegalAccessException{

        ProxyFactory proxyFactory  = new ProxyFactory();
       // proxyFactory.setSuperclass(clazz);
        Class[] clz = {clazz};
        proxyFactory.setInterfaces(clz);
        proxyFactory.setHandler(new MethodHandler() {
            public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {

               // before();
                //method = doSomething
                //method1 = public final java.lang.String com.code.base.reflect.entity.
                // SubjectImpl_$$_javassist_0._d1doSomething(java.lang.String)
                System.out.println("method = " + method.getName());
                System.out.println("method1 = " +  method1);
                //   Object result =  method.invoke(o,objects);
                Object result = method1.invoke(o,objects);



               // after();

                return  result;

            }
        });

        return  proxyFactory.createClass().newInstance();
    }

    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }

}
