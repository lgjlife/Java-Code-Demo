package com.proxy.proxy.javassist.proxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class JavassistProxy {

    public <T> T getProxy(Class<T> interfaceClass){



        ProxyFactory proxyFactory  = new ProxyFactory();

        if(interfaceClass.isInterface()){
            Class[] clz  = new Class[1];
            clz[0] = interfaceClass;
            proxyFactory.setInterfaces(clz);
        }
        else {
            proxyFactory.setSuperclass(interfaceClass);
        }


        proxyFactory.setHandler(new MethodHandler() {
            public Object invoke(Object proxy, Method method, Method method1, Object[] args) throws Throwable {
                //method 被代理类的方法
                //method1代理类的方法　使用这个方法
                System.out.println("==================");
                Object result = method1.invoke(proxy,args);
                return  result;

            }
        });

        try{

            T bean =  (T)proxyFactory.createClass().newInstance();
            return  bean;


        }
        catch(Exception ex){
            log.error("Javassit 创建代理失败:{}",ex.getMessage());
            return null;
        }



    }

    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }

}
