package com.springboot.transaction.service;

import com.springboot.transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *功能描述
 * @author lgj
 * @Description
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
public class TransServiceB {

    @Autowired
    UserMapper userMapper;


    @Transactional
    public void   func1(){



    }
}
