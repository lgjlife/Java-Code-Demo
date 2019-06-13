package com.proxy.proxy.javassist.demo;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import javassist.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;


@Slf4j
public class ReWriteDemo {

    public static void main(String args[]){
        //printClassInfo();
        //createClass();

        addMethod();



    }



    public static void  addMethod(){

        try{
            // 获取本地类加载器
            java.lang.ClassLoader classLoader =ClassLoader.getSystemClassLoader();
            // 获取要修改的类
            Class<?> clazz = classLoader.loadClass("com.proxy.proxy.javassist.demo.DemoService");

            // 实例化类型池对象
            ClassPool classPool = ClassPool.getDefault();
            // 从类型池中读取指定类型
            CtClass ctClass = classPool.get("com.proxy.proxy.javassist.demo.DemoService");


           CtField[] fields = ctClass.getDeclaredFields();
           for(CtField field:fields){
               log.info("field = " + field);
           }

            CtMethod[] methods =  ctClass.getDeclaredMethods();

            for(CtMethod method:methods){
                log.info("method = " + method);
            }

            CtMethod method = ctClass.getDeclaredMethod("printName");
            method.insertBefore("System.out.println(\"name = \" + name + \"  time =\" + new java.util.Date().toString());");


            ctClass.writeFile("./aa");
         //   Class createClass = ctClass.toClass();
            //创建对象 ，反射调用
            Class newClass = DemoService.class;
            Object instance = newClass.newInstance();
            Method setMethod = newClass.getMethod("setName",String.class);
            Method printMethod = newClass.getMethod("printName");

            setMethod.invoke(instance,"libai");
            printMethod.invoke(instance);



        }
        catch(Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }


    }
    /**
     *功能描述
     * @author lgj
     * @Description 创建类
     * 输出 ： name = libai  time =Fri Jun 14 01:45:14 CST 2019
     * @date 6/14/19
     * @param:
     * @return:
     *
    */
    public static  void createClass(){

        try{
            ClassPool classPool = ClassPool.getDefault();
            //创建类，全限定名称
            CtClass ctClass = classPool.makeClass("com.proxy.proxy.javassist.demo.JavassistDemo");
           //添加属性
            CtField field = new CtField(classPool.get(String.class.getName()),"name",ctClass);
            field.setModifiers(Modifier.PRIVATE);
            ctClass.addField(field);
            //添加setter and getter
            ctClass.addMethod(CtNewMethod.setter("setName",field));
            ctClass.addMethod(CtNewMethod.getter("getName",field));

            //添加新方法
            CtMethod ctMethod = new CtMethod(CtClass.voidType,"printName",null,ctClass);
            ctMethod.setModifiers(Modifier.PUBLIC);
            ctMethod.setBody("System.out.println(\"name = \" + name + \"  time =\" + new java.util.Date().toString());");
            ctClass.addMethod(ctMethod);


            //创建对象 ，反射调用
            Class createClass = ctClass.toClass();
            Object instance = createClass.newInstance();
            Method setMethod = createClass.getMethod("setName",String.class);
            Method printMethod = createClass.getMethod("printName");

            setMethod.invoke(instance,"libai");
            printMethod.invoke(instance);


        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


    }

    /**
     *功能描述
     * @author lgj
     * @Description 打印类信息
     * @date 6/14/19
     * @param:
     * @return:
     *
    */
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

            //field = com.proxy.proxy.javassist.demo.DemoService.name:Ljava/lang/String;
            CtField field = ctClass.getDeclaredField("name");
            log.info("field = " + field);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }
}
