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
public class Son  extends Father {


    public  void func1(LinkedHashMap map){
        System.out.println("执行子类...LinkedHashMap");
    }

    public  void func2(HashMap map){
        System.out.println("执行子类...HashMap");
    }

}
