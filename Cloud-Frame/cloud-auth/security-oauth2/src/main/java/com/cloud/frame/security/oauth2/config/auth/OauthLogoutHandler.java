package com.cloud.frame.security.oauth2.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-23 11:51
 **/
public class OauthLogoutHandler implements LogoutHandler {

    private static final Logger log = LoggerFactory.getLogger(OauthLogoutHandler.class);

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        log.info("logout .....");
    }
}
