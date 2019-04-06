package com.ch11.errhandle;

import com.ch11.exception.FirstException;
import com.ch11.exception.SecondException;
import com.ch11.model.ExceptionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: swagger
 * @description: 全局异常处理类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 01:15
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    private  static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @description: 处理通用的 Exception异常，优先级最低
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
    */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ExceptionModel exceptionHandle(Exception ex){

        log.info("进入Exception异常拦截");
        ExceptionModel exceptionModel
                = new ExceptionModel(ex.getMessage());

        return exceptionModel;

    }

    /**
     * @description: 处理自定义的 FirstException异常
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @ResponseBody
    @ExceptionHandler(value = FirstException.class)
    public ExceptionModel firstExceptionHandle(FirstException ex){

        log.info("进入FirstException异常拦截");
        ExceptionModel exceptionModel
                = new ExceptionModel(ex.getCode(),ex.getMessage());

        return exceptionModel;

    }

    /**
     * @description: 处理自定义的 SecondException异常
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/5/18
     */
    @ResponseBody
    @ExceptionHandler(value = SecondException.class)
    public ExceptionModel secondExceptionHandle(SecondException ex){

        log.info("进入SecondException异常拦截");
        ExceptionModel exceptionModel
                = new ExceptionModel(ex.getCode(),ex.getMessage());

        return exceptionModel;

    }
}
