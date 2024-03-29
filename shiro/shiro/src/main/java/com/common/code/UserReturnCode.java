package com.common.code;

/**
 * @program: shiro
 * @description: 用户相关枚举类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-02 01:06
 **/
public enum UserReturnCode implements  ReturnCode{


    //登录相关　1000-1029
    LOGIN_SUCCESS(1000,"用户登录成功"),
    LOGIN_FAIL(1001,"用户登录失败"),
    LOGIN_PASSWORD_ERR(1002,"用户登录失败,密码错误"),
    LOGIN_LOCK_ACCOUNT(1003,"用户登录失败，账户被锁定"),
    LOGIN_PASSWORD_ERR_MORE(1004,"用户登录失败，密码错误过多"),


    //注册相关　1030-1059
    ACCOUNT_EXIST(1030,"帐号注册失败,帐号已经存在"),
    NAME_EXIST(1031,"该用户名已经存在"),
    PHONE_NUM_EXIST(1032,"该手机号已经注册"),
    EMAIL_EXIST(1033,"该邮箱已经注册"),
    CAN_REGISTER(1034,"帐号未注册，可以进行注册"),

    REGISTER_SUCCESS(1035,"帐号注册成功"),
    REGISTER_FAIL(1036,"帐号注册失败")
    ;
    //代码
    private Integer code;
    //代码对应的信息
    private String message;

    UserReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }




}
