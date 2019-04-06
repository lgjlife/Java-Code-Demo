package com.cloud.frame.extern;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 16:04
 **/
public class Client {

    public static void main(String[] args) {

        Father father = new Father();
        Son son = new Son();

        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();

        father.func1(hashMap);
        son.func1(hashMap);
        System.out.println("------------");
        father.func1(linkedHashMap);
        son.func1(linkedHashMap);

        System.out.println("------------");
      //  father.func2(hashMap);
        son.func2(hashMap);
        System.out.println("------------");
        father.func2(linkedHashMap);
        son.func2(linkedHashMap);

    }

}
