package com.fancx.Admin.Exception;


import com.fancx.Common.Result.ResultCode;
import lombok.Data;

@Data
public class AdminFailMessageException extends RuntimeException {
    ResultCode resultCode;

    public AdminFailMessageException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
