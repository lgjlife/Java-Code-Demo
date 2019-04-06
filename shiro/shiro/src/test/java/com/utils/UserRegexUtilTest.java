package com.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


public class UserRegexUtilTest {

    @Test
    public void regex(){

        System.out.println(UserRegexUtil.isMobile("13925716752"));
        System.out.println(UserRegexUtil.isMobile("23925716752"));
        System.out.println(UserRegexUtil.isMobile("1392571675"));


        System.out.println(UserRegexUtil.isEmail("123456@qq.com"));
        System.out.println(UserRegexUtil.isEmail("123456@qq@.com"));
        System.out.println(UserRegexUtil.isEmail("13925716751"));


    }
}