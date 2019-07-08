package com.springboot.importselector.config;

import com.springboot.importselector.pojo.Location;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class LocationRegister implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory)beanFactory;


        //方式1
        Location location = new Location();
        listableBeanFactory.registerSingleton(Location.class.getName(),location);

        //方式2
        BeanDefinition locationBeanDefinition = new RootBeanDefinition(Location.class);
        listableBeanFactory.registerBeanDefinition(Location.class.getName(),locationBeanDefinition);


    }


}
