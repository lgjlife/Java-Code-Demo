package com.springboot.transaction.service.trans;

import com.springboot.transaction.dao.User;
import com.springboot.transaction.exception.TransException;
import com.springboot.transaction.mapper.UserMapper;
import com.springboot.transaction.service.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceA {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ServiceB serviceB;


    /**
     *功能描述 
     * @author lgj
     * @Description  A--有事务－－无异常　－－　Ｂ事务抛出异常
     * @date 4/27/19
     * @param: 
     * @return: 
     *
    */

    @Transactional
    public void func1(){

        System.out.println("第一种情况：ServiceB抛出异常，ＳerviceＡ不捕获");
        User user = UserBuilder.build();
        System.out.println("ServiceA－func1　写入的user : "+ user.getName());
        userMapper.insert(user);
        serviceB.func1(true);
    }

    /**
     *功能描述
     * @author lgj
     * @Description  A--有事务－－无异常　－－　Ｂ事务抛出异常, A捕获
     * @date 4/27/19
     * @param:
     * @return:
     *
     */
    @Transactional
    public void func2(){
        System.out.println("第二种情况：ServiceB抛出异常，ServiceＡ捕获");
        User user = UserBuilder.build();
        System.out.println("ServiceA－func2　写入的user : "+ user.getName());
        userMapper.insert(user);
        try{

            serviceB.func1(true);
        }
        catch(Exception ex){
            System.out.println("ServiceA 捕获ＳerviceＢ异常");
        }
    }

    /**
     *功能描述
     * @author lgj
     * @Description  A--有事务－－抛出异常　－－　Ｂ事务无异常
     * @date 4/27/19
     * @param:
     * @return:
     *
     */
    @Transactional
    public void func3(){
        System.out.println(" 第三种情况：ServiceB不抛出异常，ServiceＡ抛出异常");
        User user = UserBuilder.build();
        System.out.println("ServiceA－func3　写入的user : "+ user.getName());
        userMapper.insert(user);

        serviceB.func1(false);
        throw new TransException("ServiceA func3 抛出异常");

    }





}
