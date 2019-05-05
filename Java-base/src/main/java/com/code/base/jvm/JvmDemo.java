package com.code.base.jvm;

import java.util.LinkedHashMap;
import java.util.Map;
//-Xms400m -Xmx500m -Xmn200m
public class JvmDemo {


    public static Map map = new LinkedHashMap();

    public static void main(String args[]){


        int _1M =  1024 * 1024;
        for(int i = 0; i< 20000; i++){

            try{

                Thread.sleep(1000);
                byte[] data = new byte[_1M*50];

                if(i % 20  == 0){
                    map.put(i,data);
                }
               //
                //System.out.println("执行："+i);
            }
            catch(Exception ex){
                         }
        }
    }
}
