package com.spring.test.controller;

import com.spring.test.TestApplication;
import com.spring.test.dao.UserDemo;
import com.spring.test.service.UserDemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureMockMvc
public class UserDemoControllerTest {

    @Mock
    UserDemoService userDemoService;

    @InjectMocks
    UserDemoController userDemoController;



    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        MockitoAnnotations.initMocks(this);

       // mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc = MockMvcBuilders
                .standaloneSetup(userDemoController)
                .setRemoveSemicolonContent(false)
                .build();

    }



    @Test
    public void list() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void list1() throws Exception{

        UserDemo userDemo = new UserDemo();
        userDemo.setId(1000);
        userDemo.setAge(105);
        userDemo.setName("caimi");
        List<UserDemo> userDemos = new ArrayList<>();
        userDemos.add(userDemo);


        Mockito.when(userDemoService.list()).thenReturn(userDemos);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        Mockito.verify(userDemoService).list();


    }

}