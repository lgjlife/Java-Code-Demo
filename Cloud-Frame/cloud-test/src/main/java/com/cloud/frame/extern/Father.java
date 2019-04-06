package com.cloud.frame.extern;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-29 16:01
 **/
public class Father {

    public  void func1(HashMap map){
        System.out.println("执行父类...HashMap");
    }

    public  void func2(LinkedHashMap map){
        System.out.println("执行父类...LinkedHashMap");
    }



}
