package com.example.springscheduler.scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Task1 {

    //5秒执行一次
   // @Scheduled(cron = "0/10 * * * * *")
    public void work1(){
        log.info("work1");
    }


    //下一次的任务执行时间，是从方法最后一次任务执行结束时间开始计算。并以此规则开始周期性的执行任务。
    @Scheduled(fixedDelay = 1000*3)
    public void work2(){
        log.info("work2");
        try{
            Thread.sleep(5*1000);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

    }

    //按照指定频率执行任务，并以此规则开始周期性的执行调度。
    @Scheduled(fixedRate = 1000*3)
    public void work3(){
        log.info("work3");
        try{
            Thread.sleep(5*1000);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }

    }



}
