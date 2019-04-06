package com.ch9.target;

import com.ch9.target.advice.FirstTargetAdvice;
import com.ch9.target.advice.SecondTargetAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetAspectTest {

    @Autowired
    FirstTargetAdvice firstTargetAdvice;

    @Autowired
    SecondTargetAdvice secondTargetAdvice;

    @Test
    public void TargetTest(){

        firstTargetAdvice.func1(12345);
        firstTargetAdvice.func2("abcde",45678);
       // firstTargetAdvice.func3(123);

        secondTargetAdvice.func1(987456);
        secondTargetAdvice.func2("qwerty",654321);
       // secondTargetAdvice.func3(987456);

    }
}