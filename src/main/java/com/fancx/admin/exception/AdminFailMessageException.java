package com.fancx.admin.exception;


import com.fancx.common.result.ResultCode;
import lombok.Data;

@Data
public class AdminFailMessageException extends RuntimeException {
    ResultCode resultCode;

    public AdminFailMessageException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
