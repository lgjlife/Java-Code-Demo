package com.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: demo
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-29 00:07
 **/
@Setter
@Getter
@ToString
public class Student {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
