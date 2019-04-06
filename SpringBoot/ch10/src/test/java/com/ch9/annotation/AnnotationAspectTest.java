package com.ch9.annotation;

import com.ch9.annotation.advice.FirstAnnotationAdvice;
import com.ch9.annotation.advice.SecondAnnotationAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAspectTest {
    @Autowired
    FirstAnnotationAdvice firstAnnotationAdvice;

    @Autowired
    SecondAnnotationAdvice secondAnnotationAdvice;

    @Test
    public void ExecutionTest(){

        firstAnnotationAdvice.func1(12345);
        firstAnnotationAdvice.func2("abcde",45678);


        secondAnnotationAdvice.func1(987456);
        secondAnnotationAdvice.func2("qwerty",654321);


    }
}