package com.fancx.admin.result;

import com.fancx.common.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 管理员Code,6开头
 */
@Getter
@AllArgsConstructor
public enum AdminResultCode implements ResultCode {
    USERNAME_OCCUPIED(601, "用户名已被占用"),
    REGISITER_ERROR(602, "注册失败"),
    LOGIN_FAILED(603, "账号名或登录密码不正确"),
    NOT_LOGGED_IN(604, "当前未登录");

    private int code;
    private String message;

}

