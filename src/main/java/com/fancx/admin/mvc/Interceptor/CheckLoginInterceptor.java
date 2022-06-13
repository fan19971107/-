package com.fancx.admin.mvc.Interceptor;

import com.fancx.admin.exception.AdminFailMessageException;
import com.fancx.admin.result.AdminResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("#CheckLoginInterceptor");
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            throw new AdminFailMessageException(AdminResultCode.NOT_LOGGED_IN);
//        }
//        System.out.println(19);
//        System.out.println(session.getMaxInactiveInterval());
        return true;
    }
}
