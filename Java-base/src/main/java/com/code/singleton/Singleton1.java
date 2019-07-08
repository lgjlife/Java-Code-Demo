package com.code.singleton;

import java.io.Serializable;

public class Singleton1 implements Serializable {

    private static Singleton1 singleton = new Singleton1();

    public static Singleton1 getSingleton(){
        return singleton;
    }

    /*private Object readResolve(){
        return singleton;
    }*/
}
