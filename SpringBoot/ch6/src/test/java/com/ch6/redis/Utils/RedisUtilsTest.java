package com.ch6.redis.Utils;

import com.ch6.redis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    RedisUtils redisUtils;

    User user = new User("Fly",22);

    @Test
    public  void  redis(){
        redisUtils.set("name","liangguojian");
        String name = (String) redisUtils.get("name");
        System.out.println(name);

        redisUtils.set("user",user);
        User readUser = (User) redisUtils.get("user");
        System.out.println(readUser.toString());
    }
}