package com.utils.secure;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @program: shiro
 * @description: 密码加密工具类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-02 03:30
 **/
public class SecurePasswordUtil {

    public static String md5Secure(String password){

        String random=new SecureRandomNumberGenerator().nextBytes().toHex();
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String resultPassword = new Md5Hash(password,random,3).toString();
        return  resultPassword;
    }
}
