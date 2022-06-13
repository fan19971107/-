package com.fancx.admin.mvc.ExceptionHandler;

import com.fancx.admin.exception.AdminFailMessageException;
import com.fancx.admin.result.AdminResultUtil;
import com.fancx.common.result.CommonResultData;
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
