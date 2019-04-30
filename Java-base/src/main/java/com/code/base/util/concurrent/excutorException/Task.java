package com.code.base.util.concurrent.excutorException;

public class Task implements  Runnable{

    int a,b;

    public Task(int a, int b) {
        this.a = a;
        this.b = b;
    }



    @Override
    public void run() {

        int result = a/b;
        System.out.println("result = " +  result);
    }
}