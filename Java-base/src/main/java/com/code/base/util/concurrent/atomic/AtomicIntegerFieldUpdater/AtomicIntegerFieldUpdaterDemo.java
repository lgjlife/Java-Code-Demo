package com.code.base.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    private volatile int name = 0;

    public static void main(String args[]){

        AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class,"name");

        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();

        demo.name = 100;


        fieldUpdater.set(demo,123);
        int name = fieldUpdater.get(demo);
        System.out.println(name);

    }



}
