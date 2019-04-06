package com.controller;


import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
//自动配置，注入 Mock Mvc
@AutoConfigureMockMvc

@WebAppConfiguration
public class MvcMethodParamControllerTest {


    @Autowired
    private WebApplicationContext context;
    private  MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    //URI路径匹配 PathVariable
   // @Test
    public void func1Test() throws  Exception{
        mockMvc.perform(get("/mvc/method/param/func1/1234")).andExpect(status().isOk()).andDo(print());
    }
    //绑定 Model
    //@Test
    public void func2Test() throws  Exception{
        mockMvc.perform(get("/mvc/method/param/func2")).andExpect(status().isOk()).andDo(print());
    }
    //绑定 ModelAndView
   // @Test
    public void func3Test() throws  Exception{
        mockMvc.perform(get("/mvc/method/param/func3")).andExpect(status().isOk()).andDo(print());
    }

    //url?xxx=xxx
   // @Test
    public void func4Test() throws  Exception{
        mockMvc.perform(get("/mvc/method/param/func4")
        .param("name","ch4 liang"))
                .andExpect(status().isOk()).andDo(print());
    }

   // bean
    @Test
    public void func5Test() throws  Exception{

        Student stu = new Student(1234L,"liang");
        Map map = new HashMap();
        map.put("id",1234L);
        map.put("name","ch5 liang");
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        mockMvc.perform(get("/mvc/method/param/func5")
               .content(jsonObject.toString())
               .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andDo(print());
    }
    /** 
    * @description:  文件上传测试
    * @param:
    * @return:  
    * @author: Mr.lgj 
    * @date: 6/30/18 
    */ 
    //@Test
    public void func6Test() throws  Exception{

        //first file
        File firstFile = new File("upload/upload.txt");
        FileInputStream  firstFileInputStream = new FileInputStream(firstFile);
        MockMultipartFile firstMulFile =  new MockMultipartFile(
                "files","firstFile","",firstFileInputStream);

        //second file
        File secondFile = new File("upload/123.jpeg");
        FileInputStream  secondFileInputStream = new FileInputStream(secondFile);
        MockMultipartFile secondMulFile =  new MockMultipartFile(
                "files","secondFile","",secondFileInputStream);


        System.out.println("firstFile = " + "firstFile".getBytes());
        System.out.println("secondFile = " + "secondFile".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/mvc/method/param/func6")
                .file(firstMulFile)
                .file(secondMulFile))
                .andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void func7Test() throws  Exception{
        mockMvc.perform(get("/mvc/method/param/func7")).andExpect(status().isOk()).andDo(print());
    }

}