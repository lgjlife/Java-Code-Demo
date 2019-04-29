package com.code.base.thread;

public class NoVisibilly {

    private   static  boolean flag;
    private  static String name;

    static class ReaderThread extends  Thread{

        @Override
        public void run() {
            while (!flag){
                Thread.yield();
                System.out.println("name = " + name);

            }
        }
    }


    public static void main(String args[]){


        new ReaderThread().start();
        name = "kdsadf";
        flag = true;



    }

}
