package com.fancx.Admin.MVC.Interceptor;

import com.fancx.Admin.Exception.AdminFailMessageException;
import com.fancx.Admin.Result.AdminResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("#CheckLoginInterceptor");
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new AdminFailMessageException(AdminResultCode.NOT_LOGGED_IN);
        }
        return true;
    }
}
