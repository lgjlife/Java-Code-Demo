package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
//自动配置，注入 Mock Mvc
@AutoConfigureMockMvc

@WebAppConfiguration
public class MvcTestControllerTest {


    @Autowired
    private WebApplicationContext context;
    private  MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    //URI路径匹配
   // @Test
    public void func1Test() throws  Exception{
        mockMvc.perform(get("/mvc/func1")).andExpect(status().isOk()).andDo(print());
    }
    //URI路径匹配
    @Test
    public void func2Test() throws  Exception{
        mockMvc.perform(get("/mvc/func2/1234")).andExpect(status().isOk()).andDo(print());
    }
    //URI路径匹配
    //@Test
    public void func3Test() throws  Exception{
        mockMvc.perform(get("/mvc/func3/a/b/c")).andExpect(status().isOk()).andDo(print());
        mockMvc.perform(get("/mvc/func3/1/2/3")).andExpect(status().isOk()).andDo(print());
    }

    //HTTP method 匹配  GET POST DELETE PUT
    //@Test
    public void func4Test() throws  Exception{
        mockMvc.perform(get("/mvc/func4/get")).andExpect(status().isOk()).andDo(print());
        mockMvc.perform(post("/mvc/func5/post")).andExpect(status().isOk()).andDo(print());
        mockMvc.perform(delete("/mvc/func6/delete")).andExpect(status().isOk()).andDo(print());
        mockMvc.perform(put("/mvc/func7/put")).andExpect(status().isOk()).andDo(print());
    }

    //请求的媒体类型
   // @Test
    public void func8Test() throws  Exception{

        mockMvc.perform(get("/mvc/func8").contentType("application/json")).andExpect(status().isOk()).andDo(print());
    }
    //响应的媒体类型
    //@Test
    public void func9Test() throws  Exception{
        System.out.println("执行func9Test() ");
        mockMvc.perform(get("/mvc/func9").accept("application/json")).andExpect(status().isOk()).andDo(print());
    }
}