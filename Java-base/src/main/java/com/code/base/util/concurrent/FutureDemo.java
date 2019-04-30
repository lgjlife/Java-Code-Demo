package com.code.base.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String args[]){

        long start = System.currentTimeMillis();
        delay(10);
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end -start));


        ExecutorService excutor = Executors.newFixedThreadPool(10);
        Future future = ( excutor).submit(new Thread(){

            @Override
            public void run() {

                try{
                    int i = 0;
                    while (true){
                        delay(1000);
                        System.out.println("执行任务 " + i++);



                    /*System.out.println(Thread.interrupted());
                    System.out.println("interrupt = " + this.isInterrupted());*/
                    }
                }
                catch(Exception ex){
                   ex.printStackTrace();
                }

            }
        });

        try{

            Thread.sleep(100);
        }
        catch(Exception ex){

        }
       /* System.out.println("取消任务.....");
        boolean flag = future.cancel(false);
        System.out.println("flag = " + flag);
        System.out.println(future.isCancelled());*/

        ( excutor).shutdownNow();



    }

    public static  void  delay(int ms){
        for(int i = 0; i< ms; i++){

            for(long j = 0; j < 1409000L; j++){

            }
        }
    }
}
