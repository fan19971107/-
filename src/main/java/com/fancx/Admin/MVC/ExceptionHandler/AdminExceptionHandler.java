package com.fancx.Admin.MVC.ExceptionHandler;

import com.fancx.Admin.Exception.AdminFailMessageException;
import com.fancx.Admin.Result.AdminResultUtil;
import com.fancx.Common.Result.CommonResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AdminExceptionHandler {
    @ExceptionHandler(value = AdminFailMessageException.class)
    @ResponseBody
    public CommonResultData FailMessage(AdminFailMessageException e) {
        System.out.println(e.getResultCode());
        System.out.println(e.getResultCode().getCode());
        return AdminResultUtil.fail(e.getResultCode());
    }
}
