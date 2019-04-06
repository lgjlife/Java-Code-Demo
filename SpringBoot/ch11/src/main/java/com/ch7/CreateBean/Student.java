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


public class Student implements  Member{

    private  String name;
    private  Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@Configuration
class StudentConfig{
    @Bean(name="StudentBean_1")
    public  Student studentBean(){
        Student student =  new Student("student",21);
        student.setName("my is a student StudentBean_1");
        student.setAge(16);
        return student;
    }

    @Bean(name="StudentBean_2")
    public  Student studentBean2(){
        Student student =  new Student("student",21);
        student.setName("my is a student StudentBean_2 ");
        student.setAge(16);
        return student;
    }

}
