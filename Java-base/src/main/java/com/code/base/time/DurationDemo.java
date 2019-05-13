package com.code.base.time;

import java.time.Duration;

public class DurationDemo {

    public static void main(String args[]){

        Duration duration = Duration.ofMinutes(1);
        duration = Duration.ofHours(1);
        System.out.println("getSeconds = " + duration.getSeconds());
        System.out.println("getSeconds = " + duration.getSeconds());

    }
}
