package com.code.base.thread;

public class ThreadStop {

    public static void main(String args[]) throws Exception{

        StopThread stopThread =  new StopThread();
        stopThread.start();

        Thread.sleep(10);
        stopThread.interrupt();

    }
}

class StopThread extends Thread{


    @Override
    public void run() {
        super.run();

        for(int i = 0; i< 999999999 ; i++){


            try{
              //  System.out.println(this.isInterrupted());
             //   Thread.sleep(1000);
                if(this.isInterrupted()){
                    throw new InterruptedException();
                }
            }
            catch(Exception ex){
                System.out.println("thread exception...");
                break; // or return
            }
        }

        System.out.println("线程结束");

    }
}