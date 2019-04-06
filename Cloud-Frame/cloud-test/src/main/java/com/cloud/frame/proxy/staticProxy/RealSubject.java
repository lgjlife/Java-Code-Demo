package com.cloud.frame.proxy.staticProxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 18:00
 **/
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("我正在执行被代理类的方法。。。。");
    }
}
