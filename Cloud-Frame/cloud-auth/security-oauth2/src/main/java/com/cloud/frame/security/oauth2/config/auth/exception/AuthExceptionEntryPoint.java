package com.cloud.frame.security.oauth2.config.auth.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: top-parent
 * @description: token校验失败的处理
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-24 01:34
 **/
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    private static final Logger log = LoggerFactory.getLogger(AuthExceptionEntryPoint.class);

    /*@Autowired
    OAuth2Authentication oAuth2Authentication;

    @Autowired
    JdbcTokenStore jdbcTokenStore;*/


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {

        try {

            log.info("access_token 验证失败.....");
            log.info("Authorization = " + request.getHeader("Authorization"));
            log.info("Host = " + request.getHeader("Host"));
        //    OAuth2AccessToken token =jdbcTokenStore.getAccessToken(oAuth2Authentication);
        //    log.info( "token = " + token.getValue());
            response.sendRedirect("/login");

            return;
        } catch (Exception ex) {

        } finally {

        }



       /* Map map = new HashMap();
        map.put("error", "401");
        map.put("message", authException.getMessage());
        map.put("path", request.getServletPath());
        map.put("timestamp", String.valueOf(new Date().getTime()));
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), map);
        } catch (Exception e) {
            throw new ServletException();
        }*/
    }
}