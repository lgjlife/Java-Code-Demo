package com.ch12.serviceImpl;

import com.ch12.service.SchedulerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerServiceImplTest {

    @Autowired
    SchedulerService schedulerService;


    @Test
    public void newScheduler() {
        schedulerService.newScheduler();
    }

   // @Test
    public void deleteScheduler() {
    }

    //@Test
    public void modifyScheduler() {
    }


    @Test
    public void getScheduler() {
        schedulerService.getScheduler();
    }
}