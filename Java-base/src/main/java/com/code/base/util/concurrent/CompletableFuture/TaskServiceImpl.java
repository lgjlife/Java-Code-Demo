package com.code.base.util.concurrent.CompletableFuture;

public class TaskServiceImpl implements TaskService {


    @Override
    public String findUser() {


        String result = null;
        System.out.println("任务开始执行....");
        try{
            Thread.sleep(3000);

            //模仿RPC远程调用
            result = rpcRequest(true);
            System.out.println("任务执行结束....");

        }
        catch(Exception ex){
           throw new NullPointerException();
        }


        return "libai";
    }


/*public CompletableFuture<String> findUser(){
        CompletableFuture<String> future = new CompletableFuture();

        new Thread(){

            @Override
            public void run() {

                String result = null;
                System.out.println("任务开始执行....");
                try{
                    Thread.sleep(3000);
                    //模仿RPC远程调用
                    result = rpcRequest(false);

                    System.out.println("任务执行结束....");

                }
                catch(Exception ex){
                    future.completeExceptionally(ex);
                }
                future.complete(result);
            }
        }.start();

        return future;
    }*/

    /**
     *功能描述
     * @author lgj
     * @Description   模仿RPC远程调用
     * @date 4/29/19
     * @param:    flag　　　true：返回正常结果  false:抛出异常
     *
     * @return:
     *
     */
    public String rpcRequest(boolean flag){
        String result = null;
        if(flag){
            result = "libai";
        }
        else {
            throw new NullPointerException();
        }
        return  result;
    }

}
