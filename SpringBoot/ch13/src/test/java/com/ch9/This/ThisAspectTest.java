package com.ch9.This;

import com.ch9.This.advice.FirstThisAdvice;
import com.ch9.This.advice.SecondThisAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThisAspectTest {
    @Autowired
    FirstThisAdvice firstThisAdvice;

    @Autowired
    SecondThisAdvice secondThisAdvice;

    @Test
    public void TargetTest(){

        firstThisAdvice.func1(12345);
        firstThisAdvice.func2("abcde",45678);
        // firstTargetAdvice.func3(123);

        secondThisAdvice.func1(987456);
        secondThisAdvice.func2("qwerty",654321);
        // secondTargetAdvice.func3(987456);

    }
}