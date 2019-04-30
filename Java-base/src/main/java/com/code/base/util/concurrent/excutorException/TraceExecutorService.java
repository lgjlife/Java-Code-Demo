package com.code.base.util.concurrent.excutorException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceExecutorService extends ThreadPoolExecutor {

    public TraceExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(warp(task,TraceException()),Thread.currentThread().getName());
    }

    @Override
    public void execute(Runnable command) {
        super.execute(warp(command,TraceException()));
    }

    private  Exception TraceException(){
        return new Exception("TraceExecutorService exception");
    }


    private Runnable warp(Runnable task,Exception exception){

        return new Runnable() {
            @Override
            public void run() {

                try{
                    task.run();
                }
                catch(Exception ex){
                    exception.printStackTrace();
                    ex.printStackTrace();
                   throw  ex;
                }
            }
        };
    }
}
