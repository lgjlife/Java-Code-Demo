package com.ch6.redis.pojo;

/**
 * @program: swagger
 * @description: 用户类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-02 10:56
 **/

public class User  {

    private String name;
    private Integer age;

    public User() {
    }

    public User(String name,Integer age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
