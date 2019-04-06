package com.controller;

import com.dao.mapper.OsUserMapper;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
//自动配置，注入 Mock Mvc
@AutoConfigureMockMvc

@WebAppConfiguration
public class UserControllerTest {


    @Autowired
    private WebApplicationContext context;
    private  MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getUser() throws  Exception{
        mockMvc.perform(get("/user/all")).andDo(print());
    }

    @Test
    public void test() throws  Exception{

        mockMvc.perform(get("/user/test"));


    }
}