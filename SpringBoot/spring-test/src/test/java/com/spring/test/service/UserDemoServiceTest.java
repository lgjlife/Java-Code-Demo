package com.spring.test.service;

import com.spring.test.dao.UserDemo;
import com.spring.test.dao.UserDemoMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class UserDemoServiceTest {

    @Mock
    UserDemoMapper userDemoMapper;

    @InjectMocks
    UserDemoService userDemoService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void list() {

        String name = "aaa";

        UserDemo userDemo = new UserDemo();
        userDemo.setId(1000);
        userDemo.setAge(105);
        userDemo.setName(name);
        List<UserDemo> userDemos = new ArrayList<>();
        userDemos.add(userDemo);

        Mockito.when(userDemoMapper.list(name)).thenReturn(userDemos);

        List<UserDemo> userDemoList =   userDemoService.list(name);
        System.out.println("name = " + name + ", return:"+userDemoList);

        String name1 = "bbb";

        UserDemo userDemo1 = new UserDemo();
        userDemo1.setId(1000);
        userDemo1.setAge(105);
        userDemo1.setName(name1);
        List<UserDemo> userDemos1 = new ArrayList<>();
        userDemos1.add(userDemo1);

        Mockito.when(userDemoMapper.list(name1)).thenReturn(userDemos1);
        List<UserDemo> userDemoList1 =   userDemoService.list(name1);
        System.out.println("name = " + name1 + ", return:"+userDemoList1);


    }
}