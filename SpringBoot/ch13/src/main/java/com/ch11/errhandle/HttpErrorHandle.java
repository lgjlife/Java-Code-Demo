package com.ch11.errhandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: swagger
 * @description: Http请求错误统一处理
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 02:15
 **/
@RestController
public class HttpErrorHandle implements ErrorController {

    private  static final Logger log = LoggerFactory.getLogger(HttpErrorHandle.class);

    private final static String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(path  = ERROR_PATH )
    public  String error(HttpServletRequest request, HttpServletResponse response){

        log.error("访问/error" + " 请求路径："  + request.getContextPath() + request.getServletPath() + "  错误代码："  + response.getStatus());
        return response.getStatus()+"";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
