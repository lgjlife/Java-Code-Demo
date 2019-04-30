package com.code.singleton;

import java.io.Serializable;

public class Singleton2 implements Serializable {

    private static Singleton2 singleton = null;

    public synchronized static Singleton2 getSingleton(){

        if(singleton == null){
            singleton = new Singleton2();
        }

        return singleton;
    }


    private Object readResolve(){
        return singleton;
    }

}
