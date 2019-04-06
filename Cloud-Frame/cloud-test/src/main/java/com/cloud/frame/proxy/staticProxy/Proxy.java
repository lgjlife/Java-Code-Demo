package com.cloud.frame.proxy.staticProxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 18:01
 **/
public class Proxy implements Subject {

    private Subject  subject = null;

    public   Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void doSomething() {

        before();
        this.subject.doSomething();
        after();
    }


    private   void before(){
        System.out.println("我是代理类，正在执行before()");
    }
    private  void after(){
        System.out.println("我是代理类，正在执行after()");
    }
}
