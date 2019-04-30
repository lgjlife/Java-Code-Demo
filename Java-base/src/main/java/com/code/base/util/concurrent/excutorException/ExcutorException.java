package com.code.base.util.concurrent.excutorException;

import java.util.concurrent.*;

public class ExcutorException {

    public static void main(String args[]){

        func2();
    }

    static void func1(){
        ExecutorService executorService = new ThreadPoolExecutor(10,10,
                100, TimeUnit.MICROSECONDS,new LinkedBlockingDeque());

        for(int i = 0; i< 5; i++){

            Future future =  executorService.submit(new Task(50,i));

            try{

                System.out.println(future.get());
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }

    static void func2(){
        ExecutorService executorService = new TraceExecutorService(10,10,
                100, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>());

        for(int i = 0; i< 5; i++){

            executorService.submit(new Task(50,i));

        }
    }



}
