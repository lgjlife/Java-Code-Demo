package com.code.base.util.concurrent.CompletableFuture;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String args[]){

        TaskService service = new TaskServiceImpl();

        CompletableFuture<String> future = service.findUser(true);

        future.whenComplete((t,u)->{

            if(u != null){
                System.out.println("异步调用发生异常:" + u);
            }
            else {
                System.out.println("异步调用执行正常: " + t);
            }


        });



        System.out.println("主线程任务执行完毕");

    }
}

