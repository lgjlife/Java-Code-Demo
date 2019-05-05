package com.code.lambda;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public <T>  List<T> queryRed(List<T> query,Predicate<T> p){

        List<T> result = new ArrayList<>();

        for(T t:query){
            if(p.test(t)){
                result.add(t);
            }
        }

        return  result;


    }

    public static void main(String args[]){
        Demo demo = new Demo();

        List<String> all = new ArrayList<>();
        all.add("Red");
        all.add("Red");
        all.add("Blue");


        List<String> result = demo.queryRed(all,(String e)->{return e.equals("Red");});

        System.out.println("result = " + result);



    }
}
