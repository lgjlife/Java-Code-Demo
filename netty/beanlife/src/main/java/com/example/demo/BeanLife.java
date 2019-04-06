package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

//@Component
public class  BeanLife
      //  extends
        //AspectJWeavingEnabler
        implements
        //bean 级生命周期
        BeanNameAware,
        BeanFactoryAware,
        InitializingBean,
        DisposableBean,
        //容器级生命周期接口方法
        InstantiationAwareBeanPostProcessor,
        BeanPostProcessor
        //工厂后处理器接口方法



       {

    //bean 级生命周期

    @Override
    public void setBeanName(String s) {
        System.out.println("++++++++++++++bean 级生命周期 BeanNameAware  setBeanName +++++++++++++++");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("++++++++++++++bean 级生命周期 BeanFactoryAware  setBeanFactory +++++++++++++++");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("++++++++++++++bean 级生命周期 InitializingBean  afterPropertiesSet +++++++++++++++");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("++++++++++++++bean 级生命周期 DisposableBean  destroy +++++++++++++++");
    }
    //++++++++++++++++++++++++++++++++++++
    //容器级生命周期接口方法
   @Override
   public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 BeanPostProcessor  postProcess-Before-Instantiation +++++++++++++++");
       return null;
   }

   @Override
   public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 BeanPostProcessor  postProcess-After-Instantiation +++++++++++++++");
       return false;
   }

   @Override
   public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 InstantiationAwareBeanPostProcessor  postProcessProperties +++++++++++++++");
       return null;
   }

   @Override
   public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 InstantiationAwareBeanPostProcessor  postProcessPropertyValues +++++++++++++++");
       return null;
   }


   //++++++++++++++++++++++++++++++++++++

    //工厂后处理器接口方法
   /*@Override
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 AspectJWeavingEnabler  postProcessBeforeInitialization +++++++++++++++");
        return null;
   }

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       System.out.println("++++++++++++++bean 容器级生命周期接口方法 AspectJWeavingEnabler  postProcessAfterInitialization +++++++++++++++");
       return null;
   }*/


   public  void init(){
       System.out.println("Bean life init.....................");
   }

   public  void destory(){
       System.out.println("Bean life destory........................");
   }


}
