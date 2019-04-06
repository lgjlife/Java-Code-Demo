package com.dubbo.frame.common.pojo;

import java.io.Serializable;

public class RabbitUser implements Serializable {

    private  String name;
    private  int age;

    public RabbitUser() {
    }

    public RabbitUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "RabbitUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
