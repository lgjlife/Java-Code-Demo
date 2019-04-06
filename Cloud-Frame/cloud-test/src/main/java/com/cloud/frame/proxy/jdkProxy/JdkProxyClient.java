package com.cloud.frame.proxy.jdkProxy;


import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 19:10
 **/
public class JdkProxyClient {

    public static void main(String[] args) throws IOException {

        //ProxyGenerator
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println(Proxy.getProxyClass(Subject.class.getClassLoader(), Subject.class));






        // saveGeneratedFiles
        Subject subject = new RealSubject();
        MyInvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = (Subject)new MyProxy(handler,subject).getProxy();

        System.out.println("返回值 = " + proxy.doSomething()); ;

    }
}
