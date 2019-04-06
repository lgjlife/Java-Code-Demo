package com.shiro.serviceImpl;

import com.common.code.UserReturnCode;
import com.shiro.dao.mapper.UserMapper;
import com.shiro.dao.model.User;
import com.shiro.service.UserLoginService;
import com.shiro.service.UserRegisterService;
import com.utils.UserRegexUtil;
import com.utils.secure.SecurePasswordUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: shiro
 * @description: 用户注册实现类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 04:12
 **/

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private static final Logger log = LoggerFactory.getLogger("UserRegisterServiceImpl");

    @Autowired
    UserMapper userMapper;

    /** 
     * @description: 检测注册帐号是否已经注册
     * @param:  
     * @return:  　UserReturnCode.CAN_REGISTER
     *             UserReturnCode.EMAIL_EXIST
     *             UserReturnCode.PHONE_NUM_EXIST
     *             UserReturnCode.NAME_EXIST
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */ 
    @Override
    public UserReturnCode checkRegisterName(String registerName) {
        if(UserRegexUtil.isEmail(registerName)){
             Integer userId  = userMapper.checkExistByEmail(registerName);
             return (userId == null)?UserReturnCode.CAN_REGISTER:UserReturnCode.EMAIL_EXIST;
        }
        else if(UserRegexUtil.isMobile(registerName)){

            Integer userId  = userMapper.checkExistByPhone(registerName);
            return (userId == null)?UserReturnCode.CAN_REGISTER:UserReturnCode.PHONE_NUM_EXIST;
        }
        else {
            Integer userId  = userMapper.checkExistByName(registerName);
            return (userId == null)?UserReturnCode.CAN_REGISTER:UserReturnCode.NAME_EXIST;
        }
    }

    /**
     * @description: 用户提交注册请求，执行注册
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 9/2/18
    */
    @Override
    public UserReturnCode register(String registerName, String password) {

        String random=new SecureRandomNumberGenerator().nextBytes().toHex();
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String resultPassword = new Md5Hash(password,random,3).toString();

        if(UserRegexUtil.isEmail(registerName)){

            Integer userId  = userMapper.checkExistByEmail(registerName);
            if(userId == null){
                User user = new User();
                user.setEmail(registerName);
                user.setLoginPassword(resultPassword);
                user.setSalt(random);
                Integer result =  userMapper.insert(user);

                return (result != null)?UserReturnCode.REGISTER_SUCCESS:UserReturnCode.REGISTER_FAIL;

            }
            else{
                return UserReturnCode.ACCOUNT_EXIST;
            }
        }
        else if(UserRegexUtil.isMobile(registerName)){

            Integer userId = userMapper.checkExistByPhone(registerName);
            if(userId == null){
                User user = new User();
                user.setPhoneNum(registerName);
                user.setLoginPassword(resultPassword);
                user.setSalt(random);
                Integer result =  userMapper.insert(user);

                return (result != null)?UserReturnCode.REGISTER_SUCCESS:UserReturnCode.REGISTER_FAIL;

            }
            else{
                return UserReturnCode.ACCOUNT_EXIST;
            }
        }
        else {
            Integer userId  = userMapper.checkExistByName(registerName);
            log.info("userId = " + userId  + " loginName =  " + registerName);
            if(userId == null){
                User user = new User();
                user.setNickName(registerName);
                user.setLoginPassword(resultPassword);
                user.setSalt(random);
                Integer result =  userMapper.insert(user);

                log.info("result == null ? " + (result == null));

                return (result != null)?UserReturnCode.REGISTER_SUCCESS:UserReturnCode.REGISTER_FAIL;

            }
            else{
                return UserReturnCode.ACCOUNT_EXIST;
            }
        }
    }
}
