package com.test;

import org.junit.*;

/**
 * @program: ch3
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-06-28 17:37
 **/
public class TestClass1 {
    @BeforeClass
    public static  void beforeClass(){
        System.out.println("TestClass1 BeforeClass");
    }

    @Before
    public void before(){
        System.out.println("TestClass1 Before");
    }

    @Test
    public void test(){
        System.out.println("TestClass1 test");
    }

    @After
    public void after(){
        System.out.println("TestClass1 After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("TestClass1 AfterClass");
    }
}
