package com.fancx.common.result;

import lombok.Data;

@Data
public class CommonResultData<T> {
    private Integer code;//返回状态码
    private String message;//提示信息
    private T data;

    public CommonResultData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResultData(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
