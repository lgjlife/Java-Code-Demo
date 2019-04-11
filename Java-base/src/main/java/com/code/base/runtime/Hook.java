package com.code.base.runtime;

import java.io.InputStream;

/**
 *功能描述
 * @author lgj
 * @Description  钩子函数测试
 *
 * 输出：
 * 程序开始执行
 * 程序执行完毕，退出main
 * 执行钩子函数 -- 2
 * 执行钩子函数 -- 3
 * 执行钩子函数 -- 4
 * 执行钩子函数 -- 1
 * @date 4/8/19
*/
public class Hook {


    public static void main(String args[]){

        System.out.println("程序开始执行");
        try{
            Thread.sleep(100);
        }
        catch(Exception ex){

        }

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 1);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 2);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 3);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.out.println("执行钩子函数 -- " + 4);
            }
        });


        System.out.println("程序执行完毕，退出main");


    }
}


