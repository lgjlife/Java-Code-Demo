package com.bean.life.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;


@Component
public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {


    public MyInstantiationAwareBeanPostProcessor() {
        super();
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {

        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口： determineCandidateConstructors: " + beanName);
        }

        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口： getEarlyBeanReference: " + beanName);
        }

        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口： postProcessBeforeInstantiation: " + beanName);
        }

        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口： postProcessAfterInstantiation : " + beanName);
        }

        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口：  postProcessPropertyValues: " + beanName);
        }
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口： postProcessBeforeInitialization: " + beanName);
        }

        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("user")){
            System.out.println("MyInstantiationAwareBeanPostProcessor接口：  postProcessAfterInitialization: " + beanName);
        }

        return super.postProcessAfterInitialization(bean, beanName);
    }
}
