package com.ch9.execution.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutionAspectTest {

    @Autowired
    FirstExecutionAdvice firstExecutionAdvice;

    @Autowired
    SecondExecutionAdvice secondExecutionAdvice;

    @Test
    public void ExecutionTest(){

        firstExecutionAdvice.func1(12345);
        firstExecutionAdvice.func2("abcde",45678);
        firstExecutionAdvice.func3(123);

        secondExecutionAdvice.func1(987456);
        secondExecutionAdvice.func2("qwerty",654321);
        secondExecutionAdvice.func3(987456);

    }
}