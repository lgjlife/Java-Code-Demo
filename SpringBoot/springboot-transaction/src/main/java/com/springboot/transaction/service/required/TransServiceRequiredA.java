package com.springboot.transaction.service.required;

import com.springboot.transaction.TransException;
import com.springboot.transaction.dao.User;
import com.springboot.transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 *功能描述
 * @author lgj
 * @Description
 * 事务传播行为：用来描述由某一个事务传播行为修饰的方法被嵌套进另一个方法的时事务如何传播。
 *
 * 事务传播行为：
 *  REQUIRED(0): 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
 *  SUPPORTS(1):　支持当前事务，如果当前没有事务，就以非事务方式执行。
 *  MANDATORY(2):　使用当前的事务，如果当前没有事务，就抛出异常。
 *  REQUIRES_NEW(3):　新建事务，如果当前存在事务，把当前事务挂起。
 *  NOT_SUPPORTED(4):　以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 *  NEVER(5):　以非事务方式执行，如果当前存在事务，则抛出异常。
 *  NESTED(6):　如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 *
 *
 * @date 4/27/19
*/
@Service
public class TransServiceRequiredA {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TransServiceRequiredB serviceB;


    /***
     *  1.A--无事务－－无异常　－－　Ｂ事务REQUIRED抛出异常
     *  2.A--无事务－－抛出异常　－－　Ｂ事务REQUIRED
     *  ３.A--有事务－－无异常　－－　Ｂ事务REQUIRED抛出异常
     *  2.A--有事务－－抛出异常　－－　Ｂ事务REQUIRED
     */
    /**
     *功能描述
     * @author lgj
     * @Description  1.A--无事务－－无异常　－－　Ｂ事务REQUIRED抛出异常
     *               A不回滚，Ｂ回滚
     * @date 4/27/19
     * @param:
     * @return:
     *
    */
    public void   func1(){

        User user = new User();
        String name = "name:"+new Random().nextInt(10000);
        user.setName(name);
        System.out.println("Service Ａ　插入 "+ name);

        userMapper.insert(user);

        serviceB.funcExcetion(true);
    }

    /**
     *功能描述
     * @author lgj
     * @Description  2.A--无事务－－抛出异常　－－　Ｂ事务REQUIRED
     * 　　　　　　　　两个都不不回滚
     * @date 4/27/19
     * @param:
     * @return:
     *
     */
    public void   func2(){
        User user = new User();
        String name = "name:"+new Random().nextInt(10000);
        user.setName(name);
        System.out.println("Service　Ａ 插入 "+ name);

        userMapper.insert(user);

        serviceB.funcNoExcetion();
        throw new TransException("事务发生异常:TransServiceRequiredB - funcExcetion");

    }

    /**
     *功能描述
     * @author lgj
     * @Description  1.A--有事务－－无异常　－－　Ｂ事务REQUIRED抛出异常
     *               不捕获异常,两个都回滚
     *               捕获异常，事务提交时org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
     *               都会回滚
     * @date 4/27/19
     * @param:
     * @return:
     *
     */
    @Transactional
    public void   func3(){

        User user = new User();
        String name = "name:"+new Random().nextInt(10000);
        user.setName(name);
        System.out.println("Service Ａ　插入 "+ name);

        userMapper.insert(user);
        serviceB.funcExcetion(true);
       /* try{
            serviceB.funcExcetion(true);

        }
        catch(Exception ex){
            System.out.println("捕获异常:"+ex.getMessage());
        }*/
    }

    /**
     *功能描述
     * @author lgj
     * @Description  2.A--有事务－－抛出异常　－－　Ｂ事务REQUIRED
     * 　　　　　　　　两个都回滚
     * @date 4/27/19
     * @param:
     * @return:
     *
     */
    @Transactional
    public void   func4(){
        User user = new User();
        String name = "name:"+new Random().nextInt(10000);
        user.setName(name);
        System.out.println("Service　Ａ 插入 "+ name);

        userMapper.insert(user);

        serviceB.funcNoExcetion();
        throw new TransException("事务发生异常:TransServiceRequiredB - funcExcetion");

    }


}
