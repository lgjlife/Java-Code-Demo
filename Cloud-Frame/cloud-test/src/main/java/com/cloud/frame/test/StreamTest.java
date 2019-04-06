package com.cloud.frame.test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-28 16:16
 **/
public class StreamTest {

    public static void main(String[] args) {

        // 1. Individual values
        Stream stream1 = Stream.of("a", "b", "c");
       // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        Stream stream2 = Stream.of(strArray);
        Stream stream3 = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        Stream stream4 = list.stream();

        filter();
    }

    public  static void filter(){
        Stream stream1 = Stream.of("a", "b", "c");
        String[] results =  (String[])stream1.filter(a -> a=="a").toArray(String[]::new);
        for (String result:results)
        System.out.println(result);
    }

}
