package com.bean.life.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class User implements BeanFactoryAware
    , BeanNameAware
    , InitializingBean
    , DisposableBean
    ,  ApplicationContextAware

{


   /* public User() {

        System.out.println("调用User构造函数");
    }*/

    /**
     *功能描述
     * @author lgj
     * @Description   BeanFactoryAware
     * @date 4/7/19
     * @param:
     * @return:
     *
    */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware  setBeanFactory");
    }


    /**
     *功能描述
     * @author lgj
     * @Description   BeanNameAware
     * @date 4/7/19
     * @param:
     * @return:
     *
    */
    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware接口：  setBeanName = " + s);
    }

    /**
     *功能描述
     * @author lgj
     * @Description    InitializingBean
     * @date 4/7/19
     * @param:
     * @return:
     *
    */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口：  afterPropertiesSet");
    }


    /**
     *功能描述
     * @author lgj
     * @Description   DisposableBean
     * @date 4/7/19
     * @param:
     * @return:
     *
    */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口：  destroy");

    }



    @PostConstruct
    public  void init(){
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public  void destory(){
        System.out.println("PreDestroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware setApplicationContext");
    }

    public void run(){
        System.out.println("user run........................");
    }
}
