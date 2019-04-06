package com.shiro.serviceImpl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


/**
 * @program: shiro
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-01 18:48
 **/

@Service
public class SessionServiceImpl {



    public void session(){

        Subject subject = SecurityUtils.getSubject();

    }
}
