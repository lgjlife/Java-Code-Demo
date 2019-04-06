package com.ch7.CreateBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 18:01
 **/

public class Teacher implements  Member{

    private  String name;
    private  Integer age;

    public Teacher() {
    }

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
/** 
* @description:  
* @param:  Teacher 类生成Bean
* @return:  
* @author: Mr.lgj 
* @date: 7/1/18 
*/ 
@Configuration
class TeacherConfig{

    //注意使用@Bean的方法不能使用getXxx，否则无法正常生成bean 
    @Bean
    public  Teacher teacherBean(){

        return  new Teacher("my is a teacher",33);
    }
}
