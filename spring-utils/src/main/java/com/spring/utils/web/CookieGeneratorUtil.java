package com.spring.utils.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *功能描述
 * @author lgj
 * @Description   web 工具类---add the cookie to the response
 * @date 3/25/19
*/

@RestController
@Slf4j
public class CookieGeneratorUtil {


    /**
     *功能描述
     * @author lgj
     * @Description  add the cookie to the response
     * @date 3/25/19
     * @param:
     * @return:
     *
    */
    @RequestMapping("/cookie")
    public String cookie(HttpServletRequest request, HttpServletResponse response){
        CookieGenerator generator = new CookieGenerator();
        generator.setCookieName("my-cookie");
        generator.setCookiePath(request.getServletPath());
        generator.setCookieMaxAge(1000);
        generator.setCookieSecure(true);
        generator.setCookieHttpOnly(false);
        generator.addCookie(response,"123456789");
        return "cookie";

    }

    /*
    *   http://localhost:8825   response headers
    *   HTTP/1.1 200
        Set-Cookie: my-cookie=123456789; Max-Age=1000; Expires=Mon, 25-Mar-2019 03:56:33 GMT; Path=/cookie; Secure
        Content-Type: text/plain;charset=UTF-8
        Content-Length: 6
        Date: Mon, 25 Mar 2019 03:39:53 GMT

    * */
}
