package com.ch12.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: swagger
 * @description: Schedutask
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 17:09
 **/

@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class Schedutask {

    public void overTimeNotice() {
        //实际的业务

        System.out.println("OverTime start time" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        System.out.println("OverTime end time" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
