package com.fancx.Admin.Result;

import com.fancx.Common.Result.ResultCode;

/**
 * 管理员Code,6开头
 */
public enum AdminResultCode implements ResultCode {
    USERNAME_OCCUPIED(601, "用户名已被占用"),
    REGISITER_ERROR(602, "注册失败"),
    LOGIN_FAILED(603, "账号名或登录密码不正确"),
    NOT_LOGGED_IN(604, "当前未登录");

    private int code;
    private String message;

    AdminResultCode(int code, String message) {//有属性的枚举需要有构造函数
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

