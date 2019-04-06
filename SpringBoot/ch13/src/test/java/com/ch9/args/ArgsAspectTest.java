package com.ch9.args;

import com.ch9.args.advice.FirstArgsAdvice;
import com.ch9.args.advice.SecondArgsAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArgsAspectTest {

    @Autowired
    FirstArgsAdvice firstArgsAdvice;

    @Autowired
    SecondArgsAdvice secondArgsAdvice;

    @Test
    public void ExecutionTest(){

        firstArgsAdvice.func1(12345);
        firstArgsAdvice.func2("abcde",45678);
        firstArgsAdvice.func4(secondArgsAdvice);

        secondArgsAdvice.func1(987456);
        secondArgsAdvice.func2("qwerty",654321);


    }
}