package com.code.base.reflect;

import com.code.base.reflect.entity.Subject;
import com.code.base.reflect.entity.SubjectImpl;
import com.code.base.reflect.proxy.CglibProxy;
import com.code.base.reflect.proxy.JavassistProxy;
import com.code.base.reflect.proxy.JdkInvocationHandler;
import com.code.base.reflect.proxy.JdkProxy;


/**
 *功能描述 
 * @author lgj
 * 创建代理对象测试：执行10000次
 *  * jdk      : 92    95     83
 *  * cglib    : 355   403    305
 *  * javassist: 11783 11707  12970
 *
 * 方法调用时间测试： 执行100000次
 * jdk      : 55 43 65 62 61 35
 * cglib    : 52 52 55 77 50 52
 * javassist: 28 44 36 45 48 34
 *
 *
 * @Description 
 * @date 4/6/19
*/
public class Client {
    
    public static void main(String args[]){

       // timeTest(100000);

        createProxytimeTest(10000);
    }


    static void timeTest(int num){
        Long start  =  0L;
        Long end  =  0L;
        int count = 10000;

        Subject subject = new SubjectImpl();
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(subject);
        Subject proxySubject = (Subject)new JdkProxy(jdkInvocationHandler,subject).getProxy();

        Subject cglibProxySubject = (Subject)new CglibProxy().getProxy(SubjectImpl.class);



        Subject javassistProxySubject =  null;
        try{
            javassistProxySubject  = (Subject) new JavassistProxy().getProxy(SubjectImpl.class);

        }
        catch(Exception ex){

        }

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++){
            proxySubject.doSomething("JDK");
        }
        end  = System.currentTimeMillis();
        System.out.println("JDK 花费时间: " +  (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            cglibProxySubject.doSomething("CGLIB");
        }
        end  = System.currentTimeMillis();
        System.out.println("CGLIB 花费时间: " +  (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            javassistProxySubject.doSomething("javassistProxySubject");
        }
        end  = System.currentTimeMillis();
        System.out.println("javassistProxySubject 花费时间: " +  (end - start));


    }

    static void createProxytimeTest(int num){
        Long start  =  0L;
        Long end  =  0L;
        int count = 10000;

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++){
            Subject subject = new SubjectImpl();
            JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(subject);
            Subject proxySubject = (Subject)new JdkProxy(jdkInvocationHandler,subject).getProxy();

        }
        end  = System.currentTimeMillis();
        System.out.println("JDK 花费时间: " +  (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            Subject cglibProxySubject = (Subject)new CglibProxy().getProxy(SubjectImpl.class);

        }
        end  = System.currentTimeMillis();
        System.out.println("CGLIB 花费时间: " +  (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            Subject javassistProxySubject =  null;
            try{
                javassistProxySubject  = (Subject) new JavassistProxy().getProxy(SubjectImpl.class);

            }
            catch(Exception ex){

            }
        }
        end  = System.currentTimeMillis();
        System.out.println("javassistProxySubject 花费时间: " +  (end - start));


    }

    static void timeTest1(){
        Long start  =  0L;
        Long end  =  0L;
        int count = 10000;

        // nomalTest();

        start = System.currentTimeMillis();
        jdkTest(count);
        end  = System.currentTimeMillis();
        System.out.println("jdkTest 花费时间: " +  (end - start));

        System.out.println();

        start = System.currentTimeMillis();
        cglibTest(count);
        end  = System.currentTimeMillis();
        System.out.println("cglibTest 花费时间: " +  (end - start));

        System.out.println();

        start = System.currentTimeMillis();
        javassistTest(count);
        end  = System.currentTimeMillis();
        System.out.println("javassistTest 花费时间: " +  (end - start));

    }


    static  void jdkTest(int num){

        for(int i = 0; i < num; i++){
            Subject subject = new SubjectImpl();
            JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(subject);
            Subject proxySubject = (Subject)new JdkProxy(jdkInvocationHandler,subject).getProxy();
            proxySubject.doSomething("JDK");
        }
    }

    static  void cglibTest(int num){

        for(int i = 0; i < num; i++){
            Subject cglibProxySubject = (Subject)new CglibProxy().getProxy(SubjectImpl.class);
            cglibProxySubject.doSomething("CGLIB");
        }
    }

    static  void javassistTest(int num){

        for(int i = 0; i < num; i++){
            Subject javassistProxySubject =  null;
            try{
                javassistProxySubject  = (Subject) new JavassistProxy().getProxy(SubjectImpl.class);
                javassistProxySubject.doSomething("javassistProxySubject");
            }
            catch(Exception ex){

            }
        }
    }



    static  void nomalTest(){
        Subject subject = new SubjectImpl();
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(subject);
        Subject proxySubject = (Subject)new JdkProxy(jdkInvocationHandler,subject).getProxy();
        proxySubject.doSomething("JDK");

        System.out.println();

        Subject cglibProxySubject = (Subject)new CglibProxy().getProxy(SubjectImpl.class);
        cglibProxySubject.doSomething("CGLIB");

        System.out.println();


        Subject javassistProxySubject =  null;
        try{
            javassistProxySubject  = (Subject) new JavassistProxy().getProxy(SubjectImpl.class);
            javassistProxySubject.doSomething("javassistProxySubject");
        }
        catch(Exception ex){

        }
    }
}
