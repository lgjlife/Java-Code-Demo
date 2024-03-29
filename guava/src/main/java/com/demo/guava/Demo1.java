package com.demo.guava;

import com.demo.guava.pojo.GuavaPojo;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class Demo1 {

    private  static LoadingCache cache = createCache();

    public static void main(String args[]) throws  Exception{




        new Thread(){



            @Override
            public void run() {

                long count = 0  ;

                while (true){
                    count++;
                    GuavaPojo pojo = new GuavaPojo(count,"namecount"+count);


                    try{

                        Thread.sleep(2000);
                        cache.put("cache:"+count,pojo);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }


                }

            }
        }.start();
        new Thread(){

            @Override
            public void run() {


               while(true){
                   try{

                       Thread.sleep(2000);
                       GuavaPojo pojo =  (GuavaPojo)cache.get("sa");

                       ConcurrentMap<String,GuavaPojo> map = cache.asMap();
                       System.out.print("len = "+map.size() + "|"  );
                       Set<Object> ids = new HashSet<>();

                       map.forEach((k,v)->{
                           ids.add(v.getId());
                       });

                       System.out.print(ids);
                       System.out.println();

                   }
                   catch(Exception ex){
                       ex.printStackTrace();
                   }
               }



            }
        }.start();


    }


    public static  LoadingCache createCache(){
        LoadingCache<String, GuavaPojo> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .build(new CacheLoader<String,GuavaPojo>(){

                    public GuavaPojo load(String s) throws Exception {

                        System.out.println("load s =" + s);

                        return new GuavaPojo(1234l,"sada");
                    }
                });

        return  cache;
    }
}
