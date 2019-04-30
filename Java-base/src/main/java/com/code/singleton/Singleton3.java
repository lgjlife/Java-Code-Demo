package com.code.singleton;

import java.io.Serializable;

public class Singleton3 implements Serializable {

    private static Singleton3 singleton = null;

    public static Singleton3 getSingleton(){

        if(singleton == null){
            synchronized(Singleton3.class){

                if(singleton == null){
                    singleton =  new Singleton3();
                }

            }


        }
        
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }
}
