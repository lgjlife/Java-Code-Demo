package com.cloud.frame.web.controller;

import com.cloud.frame.web.aop.syslog.anno.PrintUrlAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Random;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-11 17:37
 **/
@RequestMapping("/web")
@RestController
public class WebController {

    private  static Logger log = LoggerFactory.getLogger(WebController.class);


  //  @Autowired
  //  private HttpServletRequest request;

    @PrintUrlAnno
    @GetMapping("/1")
    public  String test1( HttpServletRequest request){


        log.info("/web/1");

        Principal user = request.getUserPrincipal();

        if(user == null){
            log.debug("user is null");
        }else {
            log.debug("user = " + user.getName());
        }


        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Principal user1 = req.getUserPrincipal();

        if(user1 == null){
            log.debug("user is null");
        }else {
            log.debug("user = " + user1.getName());
        }
        HttpSession session = request.getSession();

        if(session == null){
            log.debug("session is null");
        }else {
            log.debug("session = " + session.getId());
        }
        return "web1 " + new Random().nextInt(100);
    }

    @GetMapping("/2")
    public  String test2(HttpServletRequest request){
        log.info("/web/2");
        doGet(request);
        return "web2 " + new Random().nextInt(100);
    }


    public void doGet(HttpServletRequest request)
             {
        String uri = request.getRequestURI();//返回请求行中的资源名称
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = request.getRemoteAddr();//返回发出请求的IP地址
        String params = request.getQueryString();//返回请求行中的参数部分
        String host=request.getRemoteHost();//返回发出请求的客户机的主机名
        int port =request.getRemotePort();//返回发出请求的客户机的端口号。
        System.out.println(ip);
        System.out.println(url);
        System.out.println(uri);
        System.out.println(params);
        System.out.println(host);
        System.out.println(port);
        System.out.println(getIpAddress(request));
    }


        /**
         * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
         *
         * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
         * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
         *
         * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
         * 192.168.1.100
         *
         * 用户真实IP为： 192.168.1.110
         *
         * @param request
         * @return
         */
        public static String getIpAddress(HttpServletRequest request) {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        }



}
