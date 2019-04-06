package com.spring.utils.util;

import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.List;

/**
 *功能描述
 * @author lgj
 * @Description   StopWatch 测量运行时间
 * @date 3/25/19
*/
public class StopWatchUtil {

    public static void main(String args[]){
        StopWatch stopWatch = new StopWatch("my-watch");
        stopWatch.start();

        /*try{
            Thread.sleep(998);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }*/

        List<String> list = new LinkedList<>();

        for(int i = 0; i< 1000000 ; i++){
            list.add(String.valueOf(i));
        }
        stopWatch.stop();


        System.out.println(stopWatch);


    }
}
