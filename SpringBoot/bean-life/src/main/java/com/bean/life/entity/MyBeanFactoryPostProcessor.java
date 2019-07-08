package com.bean.life.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Iterator;


//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("----------------------");
        System.out.println("MyBeanFactoryPostProcessor ---  BeanFactoryPostProcessor");


        Iterator<String> names = configurableListableBeanFactory.getBeanNamesIterator();
       /* while(names.hasNext()){
            System.out.println(names.next());
        }
*/
        User user =   configurableListableBeanFactory.getBean(User.class);
        user.run();
        System.out.println("----------------------");

    }
}
