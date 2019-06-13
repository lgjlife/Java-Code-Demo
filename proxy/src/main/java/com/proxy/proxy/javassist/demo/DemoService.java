package com.proxy.proxy.javassist.demo;


@DemoAnno
public class DemoService {

    private String name;




    private void printName(){

        System.out.println("print name");
    }
    private void printName(String name){

        System.out.println("print name:"+name);
    }

}
