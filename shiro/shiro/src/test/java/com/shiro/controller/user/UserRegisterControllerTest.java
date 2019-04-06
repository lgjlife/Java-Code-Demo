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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
//自动配置，注入 Mock Mvc
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserRegisterControllerTest {


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * @description: 测试该帐号是否可以注册
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 9/2/18
    */

    @Test
    public void checkLoginName() throws  Exception{

        String name = "dafd";
        String phone = "13925716751";
        String email = "123456@qq.com";
        String url = "/user/register/check-login-name";

;       Map map = new HashMap();
        map.put("loginName",name);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        mockMvc.perform(put(url)
                .param("loginName",name)
              //  .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        Map map1 = new HashMap();
        map1.put("loginName",phone);
        JSONObject jsonObject1 = new JSONObject(map1);
        System.out.println(jsonObject1);
        mockMvc.perform(put(url)
                .param("loginName",phone)
              //  .content(jsonObject1.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        Map map2 = new HashMap();
        map2.put("loginName",email);
        JSONObject jsonObject2 = new JSONObject(map2);
        System.out.println(jsonObject2);
        mockMvc.perform(put(url)
                .param("loginName",email)
                //.content(jsonObject2.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        Map map3 = new HashMap();
        map3.put("loginName",null);
        JSONObject jsonObject3 = new JSONObject(map3);
        System.out.println(jsonObject3);
        mockMvc.perform(put(url)
                .param("loginName",null)
                //.content(jsonObject3.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()); //.andExpect(status().isOk())
    }


    /** 
     * @description: 用户注册
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */ 
    @Test
    public void register() throws  Exception {

        String name = "皮蛋瘦肉";
        String phone = "13925716751";
        String email = "123456@qq.com";
        String password = "123456789";
        String url = "/user/register/register";

        ;
        Map map = new HashMap();

        map.put("registerName", phone);
        map.put("password", password);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        mockMvc.perform(post(url)
              //  .param("loginName", name)
                  .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());
    }
}