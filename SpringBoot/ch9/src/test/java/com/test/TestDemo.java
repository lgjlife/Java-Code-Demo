package com.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @program: ch3
 * @description: 使用Suite实现一次运行多个实例
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-06-28 17:16
 **/
@RunWith(Suite.class)
@Suite.SuiteClasses({TestClass1.class,TestClass2.class})
public class TestDemo {
}

