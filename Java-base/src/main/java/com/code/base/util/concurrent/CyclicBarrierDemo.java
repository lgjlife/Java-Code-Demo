package com.code.base.util.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String args[]){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        System.out.println(cyclicBarrier.getParties());

        for(int i = 0; i< 10; i++){

            new TashThread(cyclicBarrier).start();
        }


        while (true){

            try{
                Thread.sleep(500);
            }
            catch(Exception ex){

            }
            System.out.println("已经等待数量:" + cyclicBarrier.getNumberWaiting());
        }


    }

   static class  TashThread extends  Thread{

        private long sleepTime = 0;

        private CyclicBarrier cyclicBarrier;

        public TashThread(CyclicBarrier cyclicBarrier) {
            this.sleepTime = new Random().nextInt(10000);
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try{

                System.out.println(this.getName() + " 开始执行任务...");
                Thread.sleep(sleepTime);
                System.out.println(this.getName() + " 开始等待...");
                cyclicBarrier.await();
                System.out.println(this.getName() + " 结束执行任务...");

            }
            catch(Exception ex){
                         }

        }
    }
}
