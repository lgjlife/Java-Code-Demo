package com.ch11.model;

import lombok.Data;

/**
 * @program: swagger
 * @description: 返回客户端的异常信息
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-05 01:19
 **/
@Data
public class ExceptionModel {

    private String code;
    private  String msg;

    public ExceptionModel(String msg) {
        this.msg = msg;
    }

    public ExceptionModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
