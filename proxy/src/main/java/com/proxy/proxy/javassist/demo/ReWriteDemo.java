package com.proxy.proxy.javassist.demo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ReWriteDemo {

    public static void main(String args[]){
        printClassInfo();




    }

    public static void printClassInfo() {

        try{
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get("com.proxy.proxy.javassist.demo.DemoService");

            //获取注解
            //输出Annotation = [@com.proxy.proxy.javassist.demo.DemoAnno]
            Object[] annos = ctClass.getAnnotations();
            for(Object anno: annos){
                log.info("Annotation = [{}]",anno);

            }
            //获取方法
            //如果有方法重载，会先获取到排在前面的方法
            //输出:ctMethod = javassist.CtMethod@e28c31d9[private printName ()V]
            CtMethod ctMethod = ctClass.getDeclaredMethod("printName");
            log.info("ctMethod = " + ctMethod);

            //输出javassist.CtMethod@cea69c0f[private printName (Ljava/lang/String;)V]
            ctClass.removeMethod(ctMethod);
            ctMethod = ctClass.getDeclaredMethod("printName");
            log.info("ctMethod = " + ctMethod);

            //
            CtField field = ctClass.getDeclaredField("name");
            log.info("field = " + field);



        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }

    public void createInterface(){

        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeInterface("com.demo.JavassistInt");

      /*  CtMethod ctMethod = new CtMethod();

        ctClass.addMethod();*/


    }
}
