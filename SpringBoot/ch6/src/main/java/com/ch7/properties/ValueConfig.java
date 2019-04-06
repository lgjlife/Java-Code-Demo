package com.ch7.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @program: swagger
 * @description: 使用@Value方式读取配置信息
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 12:03
 **/
@Component
@Configuration
public class ValueConfig {

    @Autowired
    private Environment env;

    /*
    aaa=123
    aaa,bbb=345
    aaa,bbb,ccc=456
     */
    //使用@Value
    @Value("${aaa}")
    private String value1;
    @Value("${aaa.bbb}")
    private String value2;

    @Value("${aaa.bbb.ccc}")
    private String value3;

    //使用  Environment
    //必须在方法里面使用，否则会编译错误
   /* private String env1 = env.getProperty("aaa");
    private String env2 = env.getProperty("aaa.bbb");
    private String env3 = env.getProperty("aaa.bbb.ccc");*/

    @Override
    public String toString() {
        return "ValueConfig{" +

                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", env1='" + env.getProperty("aaa") + '\'' +
                ", env2='" + env.getProperty("aaa.bbb") + '\'' +
                ", env3='" + env.getProperty("aaa.bbb.ccc") + '\'' +
                '}';
    }
}

@Configuration
@PropertySource("classpath:/test.properties")
class PropConfig{
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
