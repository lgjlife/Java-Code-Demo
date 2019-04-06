package com.spring.utils.util;


import org.springframework.util.StringUtils;

/**
 *功能描述
 * @author lgj
 * @Description  StringUtilsUtil
 * @date 3/25/19
*/
public class StringUtilsUtil {
    public static void main(String args[]){

        boolean flag  = false;
        flag= StringUtils.hasLength("");
        System.out.println("hasLength = " + flag);  //false

        flag = StringUtils.hasLength("a");
        System.out.println("hasLength = " + flag);  //true

        String  inStr = "   a b   ";
        System.out.println("instr len = " + inStr.length());
        String result = StringUtils.trimWhitespace(inStr);
        System.out.println("result = " + result  + "  result  len = " + result.length());// a b   len = 3

    }
}
