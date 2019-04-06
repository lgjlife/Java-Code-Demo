package com.peterwanghao.spring.cloud.oauth.authserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 22:31
 **/

@Component
public class MyPasswordEncoder implements PasswordEncoder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String encode(CharSequence rawPassword) {
        logger.debug("加密时待加密的密码：" + rawPassword.toString());
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        logger.debug("校验时待加密的密码：" + rawPassword.toString());
        logger.debug("校验时已加密的密码：" + encodedPassword);
        return  encodedPassword.equals(rawPassword.toString());
    }
}