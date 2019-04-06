package com.ch11.exception;

import lombok.Data;

/**
 * @program: swagger
 * @description: 异常类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 01:08
 **/
@Data
public class FirstException extends  RuntimeException {

    private  String code;
    public FirstException(String code , String message) {
        super(message);
        this.code = code;
    }

}
