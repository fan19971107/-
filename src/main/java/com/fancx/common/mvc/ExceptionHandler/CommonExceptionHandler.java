package com.fancx.common.mvc.ExceptionHandler;

import com.fancx.common.exception.ImageNotFoundException;
import com.fancx.common.exception.ImageUploadFailException;
import com.fancx.common.result.CommonResultCode;
import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.CommonResultUtil;
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
        e.printStackTrace();
        return CommonResultUtil.fail(CommonResultCode.SQLIntegrityConstraintViolationException);
    }
    @ExceptionHandler(value = ImageNotFoundException.class)
    @RequestMapping(produces = "image/jpeg;charset=UTF-8")
    public void ImageNotFoundException(HttpServletResponse response){

    }
}
