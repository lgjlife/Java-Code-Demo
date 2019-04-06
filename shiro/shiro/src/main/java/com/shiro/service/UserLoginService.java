package com.shiro.service;

import com.shiro.dao.model.User;

/**
 * @program: shiro
 * @description: 用户登录服务层接口
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 04:10
 **/
public interface UserLoginService {

    void login();
    User queryUser(String loginName);
}
