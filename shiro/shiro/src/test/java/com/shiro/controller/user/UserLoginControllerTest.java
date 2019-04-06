package com.shiro.controller.user;

import org.json.JSONObject;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;




@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
//自动配置，注入 Mock Mvc
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserLoginControllerTest {


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }



    @Test
    public void login() throws  Exception {
        String name = "皮蛋瘦肉";
        String phone = "13925716751";
        String email = "123456@qq.com";
        String password = "123456789";
        String url = "/user/login/in";

        Map map = new HashMap();

        map.put("loginName", phone);
        map.put("loginPassword", password);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        mockMvc.perform(post(url)
                //  .param("loginName", name)
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());
    }


    @Test
    public void logout() {
    }
}
