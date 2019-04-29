package com.code.base.util.concurrent;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String args[]){

        TaskService service = new TaskService();

        CompletableFuture<String> future = service.findUser();

        future.whenComplete((t,u)->{

            System.out.println("t = " + t);
            System.out.println("u = " + u);
        });

        future.whenComplete((t,u)->{

            System.out.println("t = " + t);
            System.out.println("u = " + u);
        });
        future.whenComplete((t,u)->{

            System.out.println("t = " + t);
            System.out.println("u = " + u);
        });
        System.out.println("主线程任务执行完毕");

    }
}
class TaskService{

    public  CompletableFuture<String> findUser(){
        CompletableFuture<String> future = new CompletableFuture();

        TaskDo taskDo = new TaskDo(future);
        taskDo.start();

        return future;
    }


}

class TaskDo extends Thread{

    CompletableFuture<String> future;

    public TaskDo(CompletableFuture<String> future) {
        this.future = future;
    }

    @Override
    public void run() {
        System.out.println("任务开始执行....");
        try{
            Thread.sleep(1000);
        }
        catch(Exception ex){

        }
        System.out.println("任务执行结束....");


        if(true){
            try{
                future.complete("执行结果:user = libai");
                future.complete("执行结果:user = libai１");
                throw new NullPointerException();

            }
            catch(Exception ex){
                future.completeExceptionally(ex);
            }


        }
    }
}
