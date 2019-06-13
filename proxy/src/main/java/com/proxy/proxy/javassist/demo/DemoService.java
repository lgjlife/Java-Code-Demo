package com.proxy.proxy.javassist.demo;


@DemoAnno
public class DemoService {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName(){

        System.out.println("print name");
    }
    public void printName(String name){

        System.out.println("print name:"+name);
    }



}
