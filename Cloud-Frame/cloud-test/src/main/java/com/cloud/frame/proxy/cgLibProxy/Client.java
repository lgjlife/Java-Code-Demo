package com.cloud.frame.proxy.cgLibProxy;

import com.cloud.frame.proxy.jdkProxy.Subject;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 19:10
 **/
public class Client {

    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();

        RealSubject proxy = (RealSubject)cglibProxy.getProxy(RealSubject.class);

        System.out.println("返回值 = " + proxy.doSomething()); ;

    }
}
