package com.redis;

import com.Utils.RedisStringsUtil;
import com.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-29 00:11
 **/

@Component
public class SaveObjectDemo {

    private static  final Logger log = LoggerFactory.getLogger("TransactionDemo");

    @Autowired
    RedisStringsUtil<String,Student> redisStringsUtil;

    public void func(){

        Student student = new Student("wang",15);

        redisStringsUtil.set("student",student);

        Student st = redisStringsUtil.get("student");
        log.info(st.toString());

    }
}
