package com.springboot.importselector.config;


import com.springboot.importselector.pojo.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean
public class ImportAutoconfiguration {

    @Bean
    public Student student(){
        return new Student();
    }
}
