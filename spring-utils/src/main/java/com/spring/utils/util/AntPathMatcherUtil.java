package com.spring.utils.util;

import org.springframework.util.AntPathMatcher;

/**
 *功能描述 
 * @author lgj
 * @Description   AntPathMatcher  路径匹配校验
 * @date 3/25/19
*/
public class AntPathMatcherUtil {

    public static void main(String args[]){

        boolean  flag = false;

        AntPathMatcher  matcher = new AntPathMatcher();

        flag = matcher.match("/**","/a");
        System.out.println("/**,/a  = "+flag);  // true

        flag = matcher.match("/a/*","/a/b/");
        System.out.println("/a/*,/a/b/c  = "+flag);  //false


        flag = matcher.match("/a/*","/a/b/");
        System.out.println("/a/*,/a/b/  = "+flag);  //false
        String result = matcher.extractPathWithinPattern("/a/*","/a/b/c");
        System.out.println(result);//b/c

     }
}
