package com.shiro.service;

import com.common.code.UserReturnCode;

/**
 * @program: shiro
 * @description: 用户注册服务层接口
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 04:10
 **/
public interface UserRegisterService {


    UserReturnCode checkRegisterName(String registerName);

    UserReturnCode register(String registerName ,String password);
}
