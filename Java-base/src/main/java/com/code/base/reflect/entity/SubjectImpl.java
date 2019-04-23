package com.code.base.reflect.entity;


public class SubjectImpl  implements  Subject {


    public String doSomething(String var) {
        System.out.println("do doSomething : " + var);
        return "proxy:" + var;
    }

    /*@Override
    public String doSomething() {

        System.out.println("do doSomething  ");
        return "123";
    }*/
}
