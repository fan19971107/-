package com.fancx.Common.MVC.ExceptionHandler;

import com.fancx.Common.Exception.ImageNotFoundException;
import com.fancx.Common.Exception.ImageUploadFailException;
import com.fancx.Common.Result.CommonResultCode;
import com.fancx.Common.Result.CommonResultData;
import com.fancx.Common.Result.CommonResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = ImageUploadFailException.class)
    @ResponseBody
    public CommonResultData uploadImageFail(ImageUploadFailException e) {
        return new CommonResultData(e.getResultCode().getCode(), e.getMessage());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public CommonResultData SQLExceptionHandler(SQLException e) {
        return CommonResultUtil.fail(CommonResultCode.SQLIntegrityConstraintViolationException);
    }
    @ExceptionHandler(value = ImageNotFoundException.class)
    @RequestMapping(produces = "image/jpeg;charset=UTF-8")
    public void ImageNotFoundException(HttpServletResponse response){

    }
}
