package com.spring.utils.util;

import org.springframework.util.Assert;

/**
 *功能描述
 * @author lgj
 * @Description   Assert  断言工具
 * @date 3/25/19
*/
public class AssertUtil {

    public static void main(String args[]){

        String  msg = "aa";
        String  test = "bb";
        Assert.isNull(test,"test is null - 1");


        test = null;
        Assert.isNull(test,"test is null - 2");

    }
}
