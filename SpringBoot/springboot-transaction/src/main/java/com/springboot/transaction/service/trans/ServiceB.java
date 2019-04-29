package com.springboot.transaction.service.trans;

import com.springboot.transaction.exception.TransException;
import com.springboot.transaction.dao.User;
import com.springboot.transaction.mapper.UserMapper;
import com.springboot.transaction.service.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceB {

    @Autowired
    UserMapper userMapper;

    /**
     *功能描述
     * @author lgj
     * @Description
     * @date 4/27/19
     * @param:  true: 方法将抛出异常
     *          false: 方法将不抛出异常
     * @return:
     *
    */
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void func1(boolean enableException){
        User user = UserBuilder.build();
        System.out.println("ServiceB－func1　写入的user : "+ user.getName());
        userMapper.insert(user);
        if(enableException){
            throw new TransException("ServiceB func1 抛出异常");
        }

    }
}
