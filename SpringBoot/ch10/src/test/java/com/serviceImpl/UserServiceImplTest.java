package com.serviceImpl;

import com.dao.model.OsUser;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void getAll() {

        System.out.println("执行UserServiceImplTest--getAll()");
        List<OsUser> users = userService.getAll();
        if(users ==  null){
            System.out.println("users is null");
        }
        else{
            System.out.println("执行UserServiceImplTest--getAll()  成功！");
            for (OsUser user:users){
                System.out.println(user.getPhoneNum());
            }
        }


    }
}