package com.bean.life;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 *
 MyBeanFactoryPostProcessor ---  BeanFactoryPostProcessor
 BeanLifeController...
 BeanLifeService...
 MyInstantiationAwareBeanPostProcessor接口： postProcessBeforeInstantiation: user
 MyInstantiationAwareBeanPostProcessor接口： determineCandidateConstructors: user
 MyInstantiationAwareBeanPostProcessor接口： postProcessAfterInstantiation : user
 MyInstantiationAwareBeanPostProcessor接口：  postProcessPropertyValues: user
 BeanNameAware接口：  setBeanName = user
 BeanFactoryAware  setBeanFactory
 ApplicationContextAware setApplicationContext
 MyInstantiationAwareBeanPostProcessor接口： postProcessBeforeInitialization: user
 PostConstruct
 InitializingBean接口：  afterPropertiesSet
 MyInstantiationAwareBeanPostProcessor接口：  postProcessAfterInitialization: user
 BeanLifeConfiguraation  create demo bean
 初始化：com.bean.life.entity.Demo
 初始化：com.bean.life.entity.Demo1
 PreDestroy
 DisposableBean接口：  destroy
 */
@SpringBootApplication
public class BeanLifeApplication {

    public static void main(String args[]){
        SpringApplication.run(BeanLifeApplication.class,args);
    }
}
