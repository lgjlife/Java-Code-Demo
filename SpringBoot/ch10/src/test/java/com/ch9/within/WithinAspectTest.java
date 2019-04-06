package com.ch9.within;

import com.ch9.within.advice.FirstWithinAdvice;
import com.ch9.within.advice.SecondWithinAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithinAspectTest {

    @Autowired
    FirstWithinAdvice firstWithinAdvice;

    @Autowired
    SecondWithinAdvice secondWithinAdvice;

    @Test
    public void ExecutionTest(){

        firstWithinAdvice.func1(12345);
        firstWithinAdvice.func2("abcde",45678);

        secondWithinAdvice.func1(987456);
        secondWithinAdvice.func2("qwerty",654321);


    }
}