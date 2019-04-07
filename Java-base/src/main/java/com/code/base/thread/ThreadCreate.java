package com.code.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCreate {

    public static void main(String args[]){
        stype1();
    }


    public  static  void stype1(){

        Thread thread = new MyThread1();
        thread.start();

        MyThread2 thread2 = new MyThread2();
        Thread  th =  new Thread(thread2);
        th.start();


        MyThread3 thread3 = new MyThread3();
        FutureTask<Integer> result = new FutureTask<Integer>(thread3);
        Thread  th1 =  new Thread(result);
        th1.start();

        try{
            System.out.println( result.get());
        }
        catch(Exception ex){

        }



    }
}

class MyThread1  extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

class MyThread2  implements Runnable{

    public void run() {
        System.out.println("MyThread2");
    }
}

class MyThread3  implements Callable {

    public Object call() throws Exception {
        System.out.println("MyThread3");
        return 123;
    }

}