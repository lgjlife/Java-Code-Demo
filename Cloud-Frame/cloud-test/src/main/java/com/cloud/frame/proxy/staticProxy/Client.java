package com.cloud.frame.proxy.staticProxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 18:05
 **/
public class Client {

    public static void main(String[] args) {


        Proxy proxy = new Proxy(new RealSubject());
        proxy.doSomething();
    }
}
