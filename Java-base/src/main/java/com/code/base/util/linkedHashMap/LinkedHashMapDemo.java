package com.code.base.util.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String args[]){

        Map<String,Integer> map = new LinkedHashMap();

        map.put("aa",1);
        map.put("zx",2);
        map.put("tg",3);
        map.get("zx");
        map.forEach((key,value)->{

            System.out.println("key = " + key + ":value = " + value );
        });

    }
}
