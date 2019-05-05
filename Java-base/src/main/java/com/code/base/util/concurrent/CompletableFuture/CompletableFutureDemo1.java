package com.code.base.util.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo1 {

    public static void main(String args[]){
        DemoInter demo = new CompletableFutureDemo1().new Demo();
        CompletableFuture future  = demo.funcAsnc();
        System.out.println("return future");
        future.whenComplete((T,V)->{

            System.out.println("T = " + T);
            System.out.println("V = " + V);

        });

    }


    interface DemoInter{

        String func();
        default CompletableFuture funcAsnc(){
            return CompletableFuture.completedFuture(func());
        }
    }
    class Demo implements  DemoInter{

        public String func(){

            try{

                System.out.println("start...");
                Thread.sleep(5000);
                System.out.println("end....");
            }
            catch(Exception ex){

            }

            return "task done";
        }

    }
}
