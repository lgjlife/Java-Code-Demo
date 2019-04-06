package com.redis;

import com.Utils.RedisStringsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @program: demo
 * @description: Strings 命令测试
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-28 02:32
 **/

@Component
public class StringsDemo {

    private static final Logger log  =  LoggerFactory.getLogger("StringsDemo");


    @Autowired
    private RedisStringsUtil redisStringsUtil;




    public void getAndset(){

        //普通设置
        String key = "name";
        String value = "liangxxxxx";

        Boolean flag = redisStringsUtil.set(key,value);
        log.info("普通设置 set test is " + flag);

        //带过期时间设置
        String key1 = "age";
        Integer value1 = 12;

        Boolean flag1 = redisStringsUtil.set(key1,value1,15000,TimeUnit.MILLISECONDS);
        Assert.isTrue(flag1 == true,"带过期时间设置失败");
        log.info("带过期时间设置 set test is " + flag1);




    }

    public void multiSet(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("multiSet1","1");
        map.put("multiSet2","2");
        Boolean flag =  redisStringsUtil.multiSet(map);

        Assert.isTrue(flag == true,"mset设置失败");
        log.info("mset设置 multiSet test is " + flag);

    }
}
