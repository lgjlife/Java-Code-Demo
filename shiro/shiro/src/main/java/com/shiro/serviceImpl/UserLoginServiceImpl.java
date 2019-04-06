package com.shiro.serviceImpl;

import com.common.code.UserReturnCode;
import com.shiro.dao.mapper.UserMapper;
import com.shiro.dao.model.User;
import com.shiro.service.UserLoginService;
import com.utils.CheckNullUtil;
import com.utils.UserRegexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: shiro
 * @description: 用户登录实现类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 04:12
 **/

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private static final Logger log = LoggerFactory.getLogger("UserLoginServiceImpl");

    @Autowired
    UserMapper userMapper;

    @Override
    public void login() {
        User user = new User();
        user.setActualName("张飞");
        user.setLoginPassword("123456");
        userMapper.insert(user);
    }

    @Override
    public User queryUser(String loginName) {

        if(CheckNullUtil.isNullString(loginName)){
            return null;
        }
        if(UserRegexUtil.isEmail(loginName)){

            User user  = userMapper.selectByEmail(loginName);
            if(user == null){

            }
            return  user;
        }
        else if(UserRegexUtil.isMobile(loginName)){

            User user  = userMapper.selectByPhone(loginName);
            return  user;
        }
        else {
            User user  = userMapper.selectByName(loginName);
            return  user;
        }

    }
}
