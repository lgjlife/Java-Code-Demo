package com.code.base.util.concurrent.atomic.AtomicBoolean;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {

    public static void main(String args[]){

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        //相同才设置
        atomicBoolean.compareAndSet(false,true);

        System.out.println(atomicBoolean.get());
    }
}
