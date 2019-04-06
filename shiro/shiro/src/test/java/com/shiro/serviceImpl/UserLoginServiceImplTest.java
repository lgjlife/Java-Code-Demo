package com.shiro.serviceImpl;

import com.shiro.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.shiro.dao.mapper")
public class UserLoginServiceImplTest {

    @Autowired
    UserLoginService userLoginService;
    @Test
    public void login() {
        userLoginService.login();
    }
}