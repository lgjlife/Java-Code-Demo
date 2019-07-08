package com.code.base.thread.lock;

public class LockDemo {

    public static void main(String args[]){

    }
}


class Service{


    public synchronized void func() {
        this.wait();

    }
}
